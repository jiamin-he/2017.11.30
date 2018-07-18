/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 28, 2017
 Problem:    Maximum Product Subarray
 Difficulty: Medium
 Notes:
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

*/
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int res = nums[0];
        for(int i = 1, imax = res, imin = res; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);
            res = Math.max(res,imax);
        }
        return res;
    }
}


// reference: July 16th, 2018, Cooper's:
// similar as above. (every time multiply by a negative/ positive number, will switch 
// the global positive/negative. )
public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int gmin = 1;
        int gmax = 1;
        // 1 乘任何数都为1
        int res = Integer.MIN_VALUE;
        for(int val : nums){
            //此处定义一下防止被篡改掉
            int max = gmax;
            int min = gmin;
            gmax = Math.max(val,Math.max(val* max,val * min));
            gmin= Math.min(val,Math.min(val*max, val *min));
            res = Math.max(res, gmax);
        }
        return res;
    }
}