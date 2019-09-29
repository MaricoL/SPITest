package com.my.linkedhashmap;

import java.util.LinkedHashMap;

/**
 * @description 
 * @author mrjimmylin
 * @date 2019/9/27 16:54
 */
public class Test1 {

    public static void main(String[] args) {
        LinkedHashMap map = new LinkedHashMap(10,0.75f,true);
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.put("e", "e");

        map.get("b");
        map.get("a");



        System.out.println(map);
    }
}
