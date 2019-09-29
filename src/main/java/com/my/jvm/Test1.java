package com.my.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author mrjimmylin
 * @description
 * @date 2019/9/29 11:07
 */
public class Test1 {
    private static final int M = 1024 * 1024;

    private static void printMemory(String tag) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(tag);
        System.out.println(runtime.freeMemory() / M + "(可用内存)/" + runtime.totalMemory() / M + "(总内存)");
    }

    public static void main(String[] args) {
//        testStrongReference();
//        testSoftReference();
//        testWeakReference();
        testPhantomReference();
    }

    private static void testPhantomReference() {
        printMemory("原内存和总内存：");
        byte[] bytes = new byte[10 * M];
        printMemory("创建了10M的数组后：");
        // 建立虚引用
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(bytes, queue);
        printMemory("建立虚引用后：");
        System.out.println("phantomReference：" + phantomReference);
        System.out.println("phantomReference.get()：" + phantomReference.get());
        System.out.println("queue.poll()：" + queue.poll());

        bytes = null;
        printMemory("断开强引用后：");
        System.gc();
        printMemory("GC后：");
        System.out.println("phantomReference：" + phantomReference);
        System.out.println("phantomReference.get()：" + phantomReference.get());
        System.out.println("queue.poll()：" + queue.poll());

        phantomReference = null;
        printMemory("断开虚引用后：");
        System.gc();
        printMemory("GC后：");
        System.out.println("phantomReference : " + phantomReference);
        System.out.println("referenceQueue.poll() : " + queue.poll());

    }

    private static void testWeakReference() {
        printMemory("原内存和总内存：");
        WeakReference<Object> weakReference = new WeakReference<>(new byte[10 * M]);
        printMemory("创建了10M的数组，并建立弱引用后：");
        System.out.println("weakReference：" + weakReference.get());
        System.gc();
        printMemory("内存容量充足，gc后：");
        System.out.println("weakReference：" + weakReference.get());
    }

    private static void testSoftReference() {
        printMemory("原内存和总内存：");
        // 如果这样写，bytes为方法内的局部变量，为强引用，不可被GC掉
//        byte[] bytes = new byte[10 * M];
//        SoftReference<Object> softReference = new SoftReference<>(bytes);
        SoftReference<Object> softReference = new SoftReference<>(new byte[10 * M]);
        printMemory("创建了10M的数组，并建立软引用后：");
        System.out.println("softReference：" + softReference.get());
        System.gc();
        printMemory("内存容量充足，gc后：");
        System.out.println("softReference：" + softReference.get());
        SoftReference<Object> softReference2 = new SoftReference<>(new byte[4 * M]);
        printMemory("实例化一个4M的数组后：");
        System.out.println("softReference：" + softReference.get());
        System.out.println("softReference2：" + softReference2.get());
    }


    private static void testStrongReference() {
        printMemory("原内存和总内存：");
        byte[] bytes = new byte[10 * M];
        printMemory("创建了10M的数组，并建立强引用后：");
        System.gc();
        printMemory("gc后：");
        bytes = null;
        printMemory("强引用断开后：");
        System.gc();
        printMemory("gc后：");
    }
}
