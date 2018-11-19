package com.revature.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class UnderstandingCollections {
	
	/*
	 * In Java, a Collection is a group of individual objects represented
	 * as a single unit. We use them to store and organize our groups of
	 * objects. Java's collection Framework is extensive and has several 
	 * classes and interfaces with different properties and behaviors to
	 * group our entities together. 
	 * 
	 */

	public static void main(String[] args) {
		arrayExample();
		arrayListExample();
		setExample();
		mapExample();
		queueExample();
	}
	
	public static void arrayExample() {
		// arrays can be created in two different ways
		String[] stringArr = {"you can","create an array", "like this"};
		String[] stringArr2 = new String[] {"or","like","this"};
		// the size of an array cannot be changed, but it can be iterated over
		for (String s : stringArr) {
			System.out.print(s+" ");
		}
		for (String s : stringArr2) {
			System.out.print(s+" ");
		}
		System.out.println("");
	}
	
	public static void arrayListExample() {
		// an arrayList can add elements dynamically, growing and shrinking as needed
		List<String> list = new ArrayList<>();
		list.add("first string");
		list.add("second string");
		list.add(new String("third string"));
		// you can manipulate and access elements of arrayLists 
		// with .add, .remove, .get, .size
		int size = list.size();
		String first = list.get(0);
		System.out.println("1: "+first);
		String alsoFirst = list.remove(0);
		System.out.println("are they the same?" + alsoFirst == first);
		int sizeAfterRemoval = list.size();
		System.out.println("this should be false: "+ (sizeAfterRemoval == size));
	}
	
	public static void setExample() {
		// hashsets are sets (no duplicates) backed by a hash table
		// there is no guarantee about the order of elements in a hashset
		Set<String> set = new HashSet<>();
		System.out.println("adding a string to the set");
		set.add("hello");
		System.out.println("attempting to add identical string");
		set.add("hello");
		// the set size should still be 1 because duplicates are not allowed
		System.out.println("set size: "+set.size());
		set.add("different string");
		System.out.println("after adding different string, the set size is now: "+set.size());
	}
	
	public static void mapExample() {
		// Maps map keys to values, in this case the specific implementation is a hashmap 
		Map<Integer, String> map = new HashMap<>();
		System.out.println("entering values into map");
		map.put(1, "hello");
		map.put(2, "goodbye");
		System.out.println("retrieving values from map:");
		String val1 = map.get(1);
		String val2 = map.get(2);
		System.out.println("val1: "+val1);
		System.out.println("val2: "+val2);
	}
	
	public static void queueExample() {
		Queue<String> q = new ArrayDeque<>();
		q.add("first in the queue");
		q.add("second in queue");
		Iterator<String> i = q.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

}
