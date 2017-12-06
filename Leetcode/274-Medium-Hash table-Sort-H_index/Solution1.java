/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 24, 2017
 Problem:    H-index
 Difficulty: medium
 Notes:
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.
*/


class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        for(int i = 0; i < length; i++){
            if ((citations[length - i -1 ] >= i+1) && 
                (i==length - 1 || citations[length - i -2] <= i+1)) 
                return i+1; 
        }
        return 0;
    }
}