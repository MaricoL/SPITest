package com.my.myenum;

/**
 * @description 
 * @author mrjimmylin
 * @date 2019/10/8 15:19
 */
public enum Season {
    SPRING("春"),SUMMER("夏"),AUTUMN("秋"),WINTER("冬");

    private final String value;

    Season(String value) {
        this.value = value;
    }
}
