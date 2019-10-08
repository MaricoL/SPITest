package com.my.myenum;

import java.util.Arrays;

/**
 * @description 
 * @author mrjimmylin
 * @date 2019/10/8 15:21
 */
public class EnumTest {
    public static void main(String[] args) {
        Season[] enumConstants = Season.class.getEnumConstants();
        Season[] values = Season.values();
        System.out.println(Arrays.toString(enumConstants));
        System.out.println(Arrays.toString(values));
    }
}
