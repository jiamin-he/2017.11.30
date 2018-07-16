/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jan 25, 2017
 Problem:    Get minimum amount of changes
 Notes:

就是换零钱的一道题，给出total amount，如何使零钱数目最少。
第一问是给定的零钱类型，25，10，5， 1. 然后楼主greedy过了。
后来自定义的零钱类型，10，7，1。楼主知道dynamic programming能做，奈何没有联系过。。。在面试官的提示下用了最笨的方法做了。当然不满意。。。后来楼主时间不多，也没改进算法。

*/

// for 25, 10 , 5, 1: use greedy
// firstly take most 25, and then most 10, and then most 5, and then 1

// for 10, 7 ,1 , coz they are not divisor relationship
// should use dp
// the i-1, i-7, i-10 get the min one and +1

public int minNum(int n){
    int[] result=new int[n+1];
    result[0]=0;
    for(int i=1; i<=n; i++){
            if(i<7){
                    result[i]=i;
            }
            else if(i>=7 && i<10){
                    result[i]=i%7+1;
            }
            else{
                    result[i]=Math.min(result[i-1], Math.min(result[i-7], result[i-10]))+1;
            }
    }
    return result[n];
}