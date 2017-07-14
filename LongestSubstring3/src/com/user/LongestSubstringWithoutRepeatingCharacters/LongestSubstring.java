package com.user.LongestSubstringWithoutRepeatingCharacters;

/**
 *Longest Substring Without Repeating Characters   Add to List QuestionEditorial Solution  My Submissions
 *Given a string, find the length of the longest substring without repeating characters.
 *Examples:
 *Given "abcabcbb", the answer is "abc", which the length is 3.
 *Given "bbbbb", the answer is "b", with the length of 1.
 *Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *Subscribe to see which companies asked this question
 * @author user
 *给定一个字符串，找到字符串中最大的子字符串，字符不能重复
 */
public class LongestSubstring {
	
	public int lengthOfLongestSubstring(String s) {

		char[] ch = s.toCharArray();
		int maxLength = 0;
		int start = 0;
		int currLength = 0;
		if(s.length()==1){
			maxLength=1;
		}
		
		//回溯匹配
		for (int i = 1; i < ch.length; i++) {

			for (int j = i-1; j >=start; j--) {

				if (ch[j] != ch[i]) {
					//计算当前的长度
					
					currLength = i-j;
					if(maxLength < i-j+1){
						maxLength = i-j+1;
					}
				} else {
					//重复时控制起始匹配的位置
					currLength = i-j; 
					start =j+1;
					break;
				}
			}
			if(currLength>maxLength){
				maxLength = currLength;
			}
			
		}
		return maxLength;
	}

	public static void main(String[] args){
		LongestSubstring longestSubstring = new LongestSubstring();
		System.out.println(longestSubstring.lengthOfLongestSubstring("aa"));
		
	}

}
