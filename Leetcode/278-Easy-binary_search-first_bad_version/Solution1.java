/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 08, 2017
 Problem:    first bad version
 Difficulty: Easy
 Notes:

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


// 注意 mid 是怎么算的啊！！！ 我连mid 都没写对！！！
// mid = (start+end)) / 2; 这样算mid 会导致overflow！
// when start and end are all about INT_MAX , then (start+end) of course will be overflow !
// To avoid the problem we can use
// mid =  start+(end-start)/2;
// O lg N
//
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start+(end-start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
