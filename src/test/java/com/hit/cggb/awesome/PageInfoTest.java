package com.hit.cggb.awesome;

import com.hit.cggb.awesome.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Charies Gavin
 * https:github.com/guobinhit
 * @date 10/30/19,2:37 PM
 * @description page info test class
 */
public class PageInfoTest {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<String>();
        for (int i = 1; i <= 100; i++) {
            testList.add(i + "");
        }

        PageInfo<String> pageHepler = new PageInfo<String>(testList);
        PageInfo<String> pageHepler2 = new PageInfo<String>(15, 10, testList);
        PageInfo<String> pageHepler3 = new PageInfo<String>(3, 10, testList);
        PageInfo<String> pageHepler4 = new PageInfo<String>(3, 40, testList);
        PageInfo<String> pageHepler5 = new PageInfo<String>(10, 10, testList);

        System.out.println("test over.");
    }
}
