package com.hit.cggb.awesome.sequence;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 10/24/19,3:30 PM
 * @description id worker of twitter
 */
public class TwitterIdWorker {
    private final long workerId;

    private final static long twepoch = 1361753741828L;

    private long sequence = 0L;

    // Machine identification digit
    private final static long workerIdBits = 4L;

    // Machine ID Max
    private final static long maxWorkerId = -1L ^ -1L << workerIdBits;

    // Autoincrement in milliseconds
    private final static long sequenceBits = 10L;

    private final static long workerIdShift = sequenceBits;

    private final static long timestampLeftShift = sequenceBits + workerIdBits;

    private final static long sequenceMask = -1L ^ -1L << sequenceBits;

    private long lastTimestamp = -1L;

    /**
     * Construction method
     *
     * @param workerId
     */
    public TwitterIdWorker(final long workerId) {
        super();

        /**
         * Limit ID valid value range
         */
        if (workerId > this.maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format(
                    "worker Id can't be greater than %d or less than 0",
                    this.maxWorkerId));

        }
        this.workerId = workerId;
    }

    /**
     * Sign Generator
     *
     * @return Return next ID value
     */
    public synchronized long nextId() {

        long timestamp = this.timeGen();

        if (this.lastTimestamp == timestamp) {
            this.sequence = (this.sequence + 1) & this.sequenceMask;
            if (this.sequence == 0) {
                System.out.println("###########" + sequenceMask);
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }

        if (timestamp < this.lastTimestamp) {
            try {
                throw new Exception(
                        String.format(
                                "Clock moved backwards.  Refusing to generate id for %d milliseconds",
                                this.lastTimestamp - timestamp));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        this.lastTimestamp = timestamp;

        long nextId = ((timestamp - twepoch << timestampLeftShift)) | (this.workerId << this.workerIdShift) | (this.sequence);

        System.out.println("timestamp:" + timestamp + ", timestampLeftShift:"
                + timestampLeftShift + ", nextId:" + nextId + ", workerId:"
                + workerId + ", sequence:" + sequence);

        return nextId;
    }

    private long tilNextMillis(final long lastTimestamp) {

        long timestamp = this.timeGen();

        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    /**
     * Get the millisecond value of the current time
     *
     * @return millisecond value
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }
}
