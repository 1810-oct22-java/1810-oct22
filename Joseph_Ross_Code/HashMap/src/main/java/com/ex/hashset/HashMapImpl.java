package com.ex.hashset;

import java.util.Arrays;
import java.util.LinkedList;

class Node {
	
	String key;
	int value;
	
	Node(String key, int value){
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + "]";
	}
	
	@Override
	public int hashCode(){
		return key.hashCode() * new Integer(value).hashCode() * 34567;
	}
	
	@Override
	public boolean equals(Object n) {
		Node temp = (Node) n;
		if(temp == null) return false;
		if(temp == n) return true;
		
		if(!(this.key.equals(temp.key))) return false;
		if(!(this.value == temp.value)) return false;
		return true;
	}
	
}

public class HashMapImpl {
	
	LinkedList<Node>[] buckets;
	int numberOfBuckets;
	int bucketSize;
	
	/**
	 * n = number of buckets
	 * s = size of each bucket
	 * */
	public HashMapImpl(int n, int s) {
		this.numberOfBuckets = n;
		this.bucketSize = s;
	}
	
	public HashMapImpl() {
		
		this.numberOfBuckets = 4;
		this.bucketSize = 8;
		
		this.initLinkedList();
	}
	
	public void initLinkedList() {
		this.buckets = new LinkedList[this.numberOfBuckets];
		
		for(int i = 0; i < this.numberOfBuckets; i++)
			this.buckets[i] = new LinkedList();
	}
	
	public int getBucketIndex(String key) {
		
		int hash = Math.abs(key.hashCode());
		
		return hash % this.numberOfBuckets;
	}
	
	public int find(String key) {
		
		int bucketIndex = this.getBucketIndex(key);
		
		for(int x = 0; x < this.buckets[bucketIndex].size(); x++) {
			
			Node temp = this.buckets[bucketIndex].get(x);
			
			if(temp.key.equals(key)) return temp.value;			
		}
		
		return Integer.MAX_VALUE;
		
	}
	
	public boolean insert(String key, int value) {
		
		if(value >= Integer.MAX_VALUE) return false;
		
		int bucketIndex = this.getBucketIndex(key);
		
		if(this.find(key) != Integer.MAX_VALUE) return false;
		
		this.buckets[bucketIndex].add(new Node(key, value));
		return true;
		
	}

	@Override
	public String toString() {
		return "HashMapImpl [buckets=" + Arrays.toString(buckets) + ", numberOfBuckets=" + numberOfBuckets
				+ ", bucketSize=" + bucketSize + "]";
	}

	/**
	 * n = number of buckets
	 * s = size of each bucket
	 * */
	public void addBuckets(int n, int s) {
		
		LinkedList<Node>[] oldBuckets = this.buckets;
		
		this.numberOfBuckets = n;
		this.bucketSize = s;
		
		this.initLinkedList();
		
		for(int i = 0; i < oldBuckets.length; i++) {
			for(int x = 0; x < oldBuckets[i].size(); x++) {
				
				Node temp = oldBuckets[i].get(x);
				
				this.insert(temp.key, temp.value);
			}
		}
	}
}
