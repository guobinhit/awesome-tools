package com.hit.cggb.awesome;

import com.hit.cggb.awesome.pageinfo.PageHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Charies Gavin
 *         https:github.com/guobinhit
 * @date 10/30/19,2:37 PM
 * @description page info test class
 */
public class PageInfoTest {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<String>();
        for (int i = 1; i <= 100; i++) {
            testList.add(i + "");
        }

        PageHelper<String> pageHepler = new PageHelper<String>(testList);
        System.out.println(pageHepler.getList());
        PageHelper<String> pageHepler2 = new PageHelper<String>(15, 10, testList);
        System.out.println(pageHepler2.getList());
        PageHelper<String> pageHepler3 = new PageHelper<String>(3, 10, testList);
        System.out.println(pageHepler3.getList());
        PageHelper<String> pageHepler4 = new PageHelper<String>(3, 40, testList);
        System.out.println(pageHepler4.getList());
        PageHelper<String> pageHepler5 = new PageHelper<String>(10, 10, testList);
        System.out.println(pageHepler5.getList());

        System.out.println("test over.");
    }
}
