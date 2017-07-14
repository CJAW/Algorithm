package com.user.stringPartioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 给定一个字符串，分割字符串，使字符串都是回文字符串，即正读与反读一样；
 * @author user
 *
 */
public class StringPartion {

//	public List<List<String>> partition(String s) {
//
//	List<List<String>> list = new ArrayList<List<String>>();
//	List<String> newslist;
//		if (s.isEmpty()) {
//			return null;
//		}
//		if (s.length() == 1) {
//
//			newslist = new ArrayList<String>();
//			newslist.add(s);
//			list.add(newslist);
//		}
//		if(s.length() == 2){
//			newslist = new ArrayList<String>();
//			newslist.add(s);
//			newslist.add(s.indexOf(0), s);
//			
//			
//		}
//		
//
//		return list;
//	}

	public static void main(String[] args) {
		String s = "wrrr";
 		System.out.println(s.indexOf(2));

	}
	
}
