/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 15, 2017
 Problem:    number of bloomergs
 Difficulty: Easy
 Notes:
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

*/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        for(int i = 0; i < points.length; i++){
            Map<Integer,Integer> res = new HashMap<>();
            int dis = 0;
            for(int j = 0; j < points.length; j++){
                dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) 
                    + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                res.put(dis, res.getOrDefault(dis,0)+1);
            }
            for(Map.Entry<Integer,Integer> entry : res.entrySet()){
                int temp = entry.getValue();
                sum += temp * (temp - 1);
            }
        }
        
        return sum;
    }
}
