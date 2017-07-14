package com.user.MedianOfTwoSortedArrays;

/**
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 找数组中的中位数
 */

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int k = (nums1.length + nums2.length) % 2;
		double value = 0;
		if (k == 0) {
			int num1 = (nums1.length + nums2.length) / 2;
			if (num1 > nums1.length) {

			}

		}

		if (k != 0) {

			int num2 = (nums1.length + nums2.length) / 2;

		}

		return value;
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
		int[] nums1 = new int[] { 1, 2, 3, 4, 5 };
		int[] nums2 = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));

	}

}
