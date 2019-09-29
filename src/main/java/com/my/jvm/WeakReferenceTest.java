package com.my.jvm;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceTest {
	
	public static int M = 1024*1024;
	
	public static void printlnMemory(String tag){
		Runtime runtime = Runtime.getRuntime();
		int M = WeakReferenceTest.M;
		System.out.println("\n"+tag+":");
		System.out.println(runtime.freeMemory()/M+"M(free)/" + runtime.totalMemory()/M+"M(total)");
	}
	
	public static void main(String[] args){
		ReferenceQueue<Object>  referenceQueue = new ReferenceQueue<>();
		WeakReferenceTest.printlnMemory("1.原可用内存和总内存");

		//创建弱引用
//		WeakReference<Object> weakRerference = new WeakReference<Object>(new byte[10*WeakReferenceTest.M],referenceQueue);
		Item item1 = new Item("aaaa", new Object(), referenceQueue);
		Item item2 = new Item("bbbb", new Object(), referenceQueue);
		System.out.println(item1.get());
		System.out.println(item2.get());

		System.gc();

		System.out.println(item1.get());
		System.out.println(item2.get());

		Item item = null;
		while ((item = (Item) referenceQueue.poll()) != null) {
			System.out.println(item.key);
		}

	/*	WeakReferenceTest.printlnMemory("2.实例化10M的数组,并建立弱引用");
		System.out.println("weakRerference.get() : "+weakRerference.get());
		
		System.gc();
		StrongReferenceTest.printlnMemory("3.GC后");
		System.out.println("weakRerference.get() : "+weakRerference.get());

		System.out.println(referenceQueue.poll().get());*/
	}

	private static class Item extends WeakReference<Object>{
		private final String key;
		public Item(String key , Object referent, ReferenceQueue<Object> queue) {
			super(referent, queue);
			this.key = key;
		}
	}
}
