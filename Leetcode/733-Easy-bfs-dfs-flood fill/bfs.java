/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 25, 2017
 Problem:    flood fill
 Difficulty: Easy
 Notes:
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].

*/

// 25ms 13%
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int goal = image[sr][sc];
        image[sr][sc] = newColor;
        boolean[][] visited = new boolean[image.length][image[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        int[] center = {sr,sc};
        q.offer(center);
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            visited[r][c] = true;
            validate(q,image,r-1,c,visited,newColor,goal);
            validate(q,image,r,c-1,visited,newColor,goal);
            validate(q,image,r+1,c,visited,newColor,goal);
            validate(q,image,r,c+1,visited,newColor,goal);
        }
        
        return image;
        
    }
    
    public void validate(Queue<int[]> q, int[][] image, int row, int column, boolean[][] visited,int newColor,int goal){
        if( row>=0 && column>=0 && row<=image.length-1 && column<=image[0].length-1
           && visited[row][column] == false && image[row][column] == goal){
            int[] t = {row,column};
            image[row][column] = newColor;
            visited[row][column] = true;
            q.offer(t);
        }
        return;
    }
}
