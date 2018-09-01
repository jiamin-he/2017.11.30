/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 19, 2018
 Problem:    Median of Two Sorted Arrays
 Difficulty: Hard
 Notes:

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

// From Leetcode Discuss
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}


// Aug 25 2018 mine
// 68ms 7%
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res;
        if(nums1.length <= nums2.length) {
            res = helper(nums1,nums2);
        } else {
            res = helper(nums2,nums1);
        }
        return res;
    }
    
    public double helper(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int left = -1, right = m-1;
        double res = 0.0;
        if(m == 0 && n == 0) return res;
        else if(m == 0) {
            if(n%2 == 0) {
                res = (nums2[n/2-1]+nums2[n/2])/2.0;
            } else {
                res = nums2[n/2];
            }
            return res;
        }
        while(left <= right) {
            int i = left + (right-left)/2;
            int j = (m+n)/2-i-2;
            if(i!=m-1 && nums2[j] > nums1[i+1]) {
                left = i+1;
            } else if(i!=-1 && nums2[j+1] < nums1[i]) {
                right = i;
            } else {
                int maxLeft = (i == -1? nums2[j] : (j == -1? nums1[i]:Math.max(nums1[i], nums2[j])));
                int minRight = (i == m-1? nums2[j+1]: (j==n-1? nums1[i+1] :Math.min(nums1[i+1], nums2[j+1])));
                if((m+n)%2 == 0) {
                    res = (maxLeft + minRight)/2.0;
                } else {
                    res = minRight;
                }
                return res;
            }
        }
        return res;
    }
}