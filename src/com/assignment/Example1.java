package com.assignment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input="G@@d e^en1ng!";
		
		int count=0;
		char s;
		
		for(int i=0;i<input.length();i++) {
			 s=input.charAt(i);
			if(!Character.isLowerCase(s) && !Character.isUpperCase(s) && !Character.isDigit(s)){
				
				count++;
				
			}
		}
		
		System.out.println(count);
		
		
		  String s1="Happy New Year";
	      String p=s1.substring(s1.length()-1, 0);
	      System.out.println(s1);
	      
	      char[] x=p.toCharArray();

	      Set<String> name=new HashSet(Arrays.asList(x));
	      

	}

}
