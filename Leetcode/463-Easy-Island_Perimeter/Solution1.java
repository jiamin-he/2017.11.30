/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Oct 01, 2017
 Problem:    Solution1.java
 Difficulty: Easy
 Notes:

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

eg

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
Explanation: The perimeter is the 16 yellow stripes in the image below:
【pic】

*/


// 167ms 20.8%
// 判断为1 的元素 与其周围 4元素的关系
import java.util.Arrays;

class Solution1 {

    public int islandPerimeter1(int[][] grid){
    	int perimeter = 0, count = 0;
    	for (int i = 0 ; i < grid.length ; i++ ) {
    		for (int j = 0 ; j < grid[0].length ; j++ ) {
    			if (grid[i][j] == 1 ) {	
    				if (j > 0 && grid[i][j-1] == 1 ) {
    					count++;
    				}
    				if (i < (grid.length - 1 ) && grid[i+1][j] == 1 ) {
    					count++;
    				}
    				if (i > 0 && grid[i-1][j] == 1 ) {
    					count++;
    				}
    				if (j < (grid[0].length - 1) && grid[i][j+1] == 1 ) {
    					count++;
    				}

    				// switch (count) {
    				// 	case 0: perimeter += 4; System.out.println(4 + " ");break;
    				// 	case 1: perimeter += 3; System.out.println(3 + " ");break;
    				// 	case 2: perimeter += 2; System.out.println(2 + " ");break;
    				// 	case 3: perimeter += 1; System.out.println(1 + " ");break;
    				// 	case 4: perimeter += 0; System.out.println(0 + " ");break;
    				// }
    				switch (count) {
    					case 0: perimeter += 4; break;
    					case 1: perimeter += 3; break;
    					case 2: perimeter += 2; break;
    					case 3: perimeter += 1; break;
    					case 4: perimeter += 0; break;
    				}
    				count = 0;
    				
    			}

    			// else System.out.println(0 + "null");

    		}
    	}

    	return perimeter;
    }

    
    //提交的简洁版（删除上面的注释等）
    public int islandPerimeterSubmitted1(int[][] grid) {
       int perimeter = 0, count = 0;
    	for (int i = 0 ; i < grid.length ; i++ ) {
    		for (int j = 0 ; j < grid[0].length ; j++ ) {
    			if (grid[i][j] == 1 ) {	
    				if (j > 0 && grid[i][j-1] == 1 ) count++;
    				if (i < (grid.length - 1 ) && grid[i+1][j] == 1 ) count++;
    				if (i > 0 && grid[i-1][j] == 1 ) count++;
    				if (j < (grid[0].length - 1) && grid[i][j+1] == 1) count++;
    				switch (count) {
    					case 0: perimeter += 4; break;
    					case 1: perimeter += 3; break;
    					case 2: perimeter += 2; break;
    					case 3: perimeter += 1; break;
    					case 4: perimeter += 0; break;
    				}
    				count = 0;
    			}
    		}
    	}
    	return perimeter; 
    }

    public int islandPerimeterSubmitted2(int[][] grid) {
       int perimeter = 0;
    	for (int i = 0 ; i < grid.length ; i++ ) {
    		for (int j = 0 ; j < grid[0].length ; j++ ) {
    			if (grid[i][j] == 1 ) {	
    				if ((j > 0 && grid[i][j-1] == 0) || j == 0 ) perimeter++; 
    				if ((i < (grid.length - 1 )  && grid[i+1][j] == 0 ) || i == (grid.length - 1 )) perimeter++;
    				if ((i > 0 && grid[i-1][j] == 0 ) || i == 0 ) perimeter++;
    				if ((j < (grid[0].length - 1) && grid[i][j+1] == 0) || j == (grid[0].length - 1)) perimeter++;			
    			}
    		}
    	}
    	return perimeter; 
    }


    public static void main(String[] args) {
        
        long start = System.currentTimeMillis(); // 记录起始时间

        //int[][] array = new int[rows][columns];
       //  int [][] grid = {{0,1,0,0},
 						//  {1,1,1,0},
						 // {0,1,0,0},
						 // {1,1,0,0},
						 // {1,1,0,0}} ;
		int [][] grid = {{0,1,0,0},
 						 {1,1,1,0},
						 {0,1,0,0},
						 {1,1,0,0}} ;

        // to print 2D array
        System.out.println(Arrays.deepToString(grid));

        //to print 1D array
  		//int[] array = new int[size];
		// System.out.println(Arrays.toString(array));
		
        System.out.println(grid.length);
        System.out.println(grid[0].length);

        Solution1 s1 = new Solution1();
        System.out.println(s1.islandPerimeter1(grid));

        long end = System.currentTimeMillis();       // 记录结束时间
        System.out.println("time: "+(end-start)+"ms");              // 相减得出运行时间

    }
}
