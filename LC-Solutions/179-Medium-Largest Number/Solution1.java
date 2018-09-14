/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 8, 2018
 Problem:    Largest Number
 Difficulty: Medium
 Notes:
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/

// sort via custom comparator!!!
// 但是我很认真在想怎么比 按位比还是怎么的比
// 总是有corner case
// 很难考虑得很周到
// 以下不work！！
class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> toBeSorted = new ArrayList<>();
        for(int num: nums) {
            toBeSorted.add(Integer.toString(num));
        }
        toBeSorted.sort(new Comparator<String>(){
            public int compare(String s1, String s2) {
                int p = 0, i = 0;
                char c1, c2;
                while(p < s1.length() || p < s2.length()) {
                    c1 = p>=s1.length()? s1.charAt(i++): s1.charAt(p);
                    c2 = p>=s2.length()? s2.charAt(i++): s2.charAt(p);
                    if(c1 < c2) {
                        return 1;
                    } else if (c1 > c2) {
                        return -1;
                    } else {
                        p++;
                    }
                }
                if(s1.length() == s2.length()) {
                    return 0;    
                } else if( p == s1.length()) {
                    
                }
                
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s: toBeSorted) {
            sb.append(s);
        }
        return sb.toString();
    }
}

// 可是可以很简单不做作的比较啊！！！
// 注意corner case [0,0,0] 不要return成“000” 啊
class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> toBeSorted = new ArrayList<>();
        for(int num: nums) {
            toBeSorted.add(Integer.toString(num));
        }
        toBeSorted.sort(new Comparator<String>(){
            public int compare(String s1, String s2) {
                String a = s1+s2;
                String b = s2+s1;
                return b.compareTo(a);
            }
        });
        if(toBeSorted.get(0).equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s: toBeSorted) {
            sb.append(s);
        }
        return sb.toString();
    }
}