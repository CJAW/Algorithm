package com.user.permutations;
import java.util.ArrayList;
import java.util.List;

public class Permutations {

	
	//冒泡排序
//	List<List<Integer>> list = new ArrayList<List<Integer>>();
//	List<Integer> mutlList;
//
//	public List<List<Integer>> permute(int[] nums) {
//
//		if (nums.length == 0) {
//
//			return null;
//		}
//
//		if (nums.length == 1) {
//			mutlList = new ArrayList<Integer>();
//			mutlList.add(nums[0]);
//
//			list.add(mutlList);
//
//		}
//
//		if (nums.length > 1) {
//
//			int x, y;
//
//			mutlList = new ArrayList<Integer>();
//			for (int i = 0; i < nums.length; i++) {
//				mutlList.add(nums[i]);
//			}
//			list.add(mutlList);
//
//			for (x = 0; x < nums.length; x++) {
//
//				
//				
//				int j = nums.length - 1;
//				
//                //冒泡遍历
//				for (y = 0; y < nums.length; y++) {
//
//					if (j == 0) {
//						break;
//					}
//					if (nums[j] > nums[j - 1]) {
//
//
//						int z = nums[j - 1];
//						nums[j - 1] = nums[j];
//						nums[j] = z;
//						mutlList = new ArrayList<Integer>();
//						for (int i = 0; i < nums.length; i++) {
//							mutlList.add(nums[i]);
//						}
//						list.add(mutlList);
//						j--;
//						
//						
//					} else {
//
//						
//						mutlList = new ArrayList<Integer>();
//						for (int i = 0; i < nums.length; i++) {
//							mutlList.add(nums[i]);
//						}
//
//						list.add(mutlList);
//						j--;
//						x++;
//						continue;
//					}
//				}
//
//			}
//		}
//		return list;
//	}

	// 全排序,深度优先排序
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	List<Integer> mutlList;
	int[] first; 

	public List<List<Integer>> permute(int[] nums) {

		if (nums.length == 0) {

			return null;
		}

		if (nums.length == 1) {
			mutlList = new ArrayList<Integer>();
			mutlList.add(nums[0]);

			list.add(mutlList);

		}
		
		
		if(nums.length==2){
			for (int b = 0; b < nums.length; b++) {

				if (b == 0) {
					first = nums;
					
				}
				int x, y;
				for (x = 0; x < first.length - 1; x++) {

					for (y = first.length-1; y >= 1; y--) {

						int z = first[y];

						first[y] = first[y - 1];

						first[y - 1] = z;

						mutlList = new ArrayList<Integer>();

						for (int i = 0; i < first.length; i++) {
							mutlList.add(first[i]);
						}

						list.add(mutlList);
					}
				}
			}
		}
		

		//使用三个维度
		if (nums.length > 2) {

			for (int b = 0; b < nums.length; b++) {

				if (b == 0) {
					first = nums;
					
				}

				if (b > 0 && b < nums.length) {

						int z = nums[0];

						nums[0] = nums[nums.length -b];

						nums[nums.length - b] = z;

						first = nums;
				}
			
				int x, y;
				for (x = 0; x < first.length - 1; x++) {

					for (y = first.length-1; y > 1; y--) {

						int z = first[y];

						first[y] = first[y - 1];

						first[y - 1] = z;

						mutlList = new ArrayList<Integer>();

						for (int i = 0; i < first.length; i++) {
							mutlList.add(first[i]);
						}

						list.add(mutlList);
					}
				}
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Permutations permutations = new Permutations();

		int[] t = {1,2,5,3,-1,4};

		System.out.println(permutations.permute(t));
		System.out.println(permutations.permute(t).size());
		System.out.println(t.length);
	}

}
