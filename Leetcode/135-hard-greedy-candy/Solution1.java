/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 14, 2017
 Problem:    candy
 Difficulty: hard
 Notes:
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

*/

class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Queue<Integer> increase = new LinkedList<>();
        Stack<Integer> decrease = new Stack<>();
        int i = 0;
        int start = 1;
        if(ratings.length < 2) return 1;
        while( i < ratings.length - 1){
            while( i < ratings.length - 1 && ratings[i] < ratings[i+1]){
                increase.offer(i++);
            }
            increase.offer(i);
            start = 1;
            while(!increase.isEmpty()){
                int temp = increase.poll();
                if(candies[temp] == 0) candies[temp] = start++;
                else{
                    candies[temp] = Math.max(candies[temp], start++);
                }
            }
            while(i < ratings.length - 1 && ratings[i] == ratings[i+1]){
                candies[++i] = 1;
            }
            while(i < ratings.length - 1 && ratings[i] > ratings[i+1]){
                decrease.add(i++);
            }
            decrease.add(i);
            start = 1;
            while(!decrease.isEmpty()){
                int temp = decrease.pop();
                if(candies[temp] == 0) candies[temp] = start++;
                else{
                    candies[temp] = Math.max(candies[temp], start++);
                }
            }
        }
        
        int sum = 0;
        for(int j = 0; j < candies.length; j++){
            sum += candies[j];
        }
        return sum;
    }
}
