/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 08, 2018
 Problem:    Trapping Rain Water
 Difficulty: hard
 Notes:

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

// mine. can only deal with nge.(next greater element)
// but if [0,1,1,7,4,3,3,2,4,3,6] or [0,1,1,6,4,3,3,2,4,3,6,4,5] will not work. (coz they not only nge.)
// for 7-->6, or 6-->4-->5, the right part is smaller , not greater, but still can trap water.

// then add the "prev greater element" method to deal with those cases
// 4% 78ms 

class Solution {
    public int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] res = new int[nums.length];
        for(int i = 1; i < nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = -1;
        }
        
        return res;
    }
    
    public int[] prevGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.length-1);
        int[] res = new int[nums.length];
        for(int i = nums.length-2; i >=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                res[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = -1;
        }
        
        return res;
    }
    
    public int trap(int[] height) {
        int len = height.length;
        if(len < 1) return 0;
        
        int[] maxLeftIndex = prevGreaterElement(height);
        int[] maxRightIndex = nextGreaterElement(height);
        
        int res = 0;
        for(int i = 1; i < height.length-1; i++){
            if((height[i-1]>height[i] && maxRightIndex[i] > -1 && maxLeftIndex[i]>-1) || (height[i-1]<height[i] && maxLeftIndex[i] > -1&& maxRightIndex[i] > -1)) {
                
                int temp = (Math.min(height[maxLeftIndex[i]],height[maxRightIndex[i]]) - height[i]) *(maxRightIndex[i]-maxLeftIndex[i]-1);
                System.out.println("i: " + i + " left: "+height[maxLeftIndex[i]] +" right: "+height[maxRightIndex[i]] + " left index: "+maxLeftIndex[i] +" right index: "+maxRightIndex[i] +" temp: " + temp);
                res += temp;
            }
        }
        return res;
    }
}

