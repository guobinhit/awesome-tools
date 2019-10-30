package com.hit.cggb.awesome.pagehelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 10/24/19,6:45 PM
 * @description page info
 */
public class PageInfo<T> {
    // Current page
    private int pageNum;
    // Quantity per page
    private int pageSize;
    // Number of current pages
    private int size;
    // Page count
    private int pages;
    // The flag of first page
    private boolean isFirstPage = false;
    // The flag of last page
    private boolean isLastPage = false;
    // Total number of records
    private long total;
    // Result set
    private List<T> list;

    /**
     * Construction method
     *
     * @param list pending divide page list
     */
    public PageInfo(List<T> list) {
        // default pageNum is 1 & pageSize is 10
        this(1, 10, list);
    }

    /**
     * Construction method
     *
     * @param pageNum  current page
     * @param pageSize quantity per page
     * @param list     pending divide page list
     */
    public PageInfo(int pageNum, int pageSize, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.list = list;
        this.pageHelper();
    }

    /**
     * Divide page help method
     */
    private void pageHelper() {
        total = list.size();
        pages = (int) Math.ceil((double) total / (double) pageSize);

        // Initial target result scope
        int startIndex = (pageNum - 1) * pageSize + 1;
        int endIndex = pageNum * pageSize;

        if (pageNum == 1) {
            isFirstPage = true;
        }
        if (pageNum == pages) {
            isLastPage = true;
        }

        /**
         * Condition 1
         */
        if (total < startIndex) {
            list = new ArrayList<T>();
            size = list.size();
        }

        /**
         * Condition 2
         */
        if (total > endIndex) {
            list = list.subList(startIndex - 1, endIndex);
            size = list.size();
        }

        /**
         * Condition 3
         */
        if (total >= startIndex && total <= endIndex) {
            list = list.subList(startIndex - 1, (int) total);
            size = list.size();
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
