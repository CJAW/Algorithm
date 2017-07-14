package com.user.TwoSum;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target
 * 输入一个数target，在数组中相加进行匹配
 * @author user
 *
 */
public class TwoSum {
	
	int[] num;
	
	public int[] twoSum(int[] nums, int target) {

		int j ,i;
		
		for ( i = 0; i < nums.length; i++) {
			
			num =new int[2];
			
			int x = target - nums[i];
			
			num[0] = i;
			
			for (j = 0; j < nums.length; j++) {
				
                 if(j==i){
					continue;
				}
               
                if(nums[j] == x) {
					num[1] = j;
					break;
					
				}
			}
	
			if(nums[i]+nums[num[1]]==target&&num[0]-num[1]!=0){
				
				break;
			}
		}

		return num;
	}
	
	public static void main(String[] args){
		
		TwoSum twoSum = new TwoSum();
		
		int[] t = {2,4,4,5,10,30};
		
		int[] z = twoSum.twoSum(t,8);
		
		System.out.println(z[0]+"   "+z[1]);
		
	}
	
	
}
