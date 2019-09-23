package com.my.spi;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description 
 * @author mrjimmylin
 * @date 2019/9/19 9:42
 */
public class Test1 {
    public static void main(String[] args) throws SQLException {
//        Thread.currentThread().setContextClassLoader(com.my.spi.Test1.class.getClassLoader().getParent());

//        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
//        Iterator<Driver> iterator = loader.iterator();
//        while (iterator.hasNext()) {
//            Driver driver = iterator.next();
//            System.out.println("driver class：" + driver.getClass() + " ， loader：" + driver.getClass().getClassLoader());
//        }
//        System.out.println("当前的上下文类加载器为：" + Thread.currentThread().getContextClassLoader());
//        System.out.println("ServiceLoader的类加载器为：" + loader.getClass().getClassLoader());

        DriverManager.getConnection("");
    }

}
