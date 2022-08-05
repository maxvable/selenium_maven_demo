package com.assignment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		 
		int[] example = {23,567,83,23,402,83,78,6,103};
		int length=example.length;
		int a=0;
		int ab[]=example;
		System.out.println(ab.length);
		for(int i=0; i<length;i++) {
		for(int j=0;j<length;j++) {	
		if(example[i] > example[j]) {
			
			a=example[i];
			example[i]=example[j];
			example[j]=a;
		}
		}
		
	}
	Set<Integer> set=new <Integer> HashSet(Arrays.asList(ab));
	
		Iterator it=set.iterator();
		while(it.hasNext()) {
		System.out.println(it.next());
		
		}
		
		
		
}
}
