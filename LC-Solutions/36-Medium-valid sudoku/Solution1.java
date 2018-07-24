/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       July 21, 2018
 Problem:    valid sudoku
 Difficulty: medium
 Notes:
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.

*/


// 21ms 32%
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> res = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') {
                    if(!res.add(board[i][j]+"row"+i) || !res.add(board[i][j]+"col"+j) || !res.add(board[i][j]+"block"+i/3+j/3))
                        return false;
                }
            }
        }
        return true;
    }
}

// 17ms 96%
class Solution {
   public static boolean isValidSudoku(char[][] board) {
        int[] count=new int[10];
        for(int i=0;i<9;i++) {//判断行是否有重复数字
            clear(count);
            for(int j=0;j<9;j++) {
                char c=board[i][j];
                if(c!='.') {
                    count[c-'0']++;
                    if(count[c-'0']>=2)
                        return false;
                }	
            }	
        }

        for(int j=0;j<9;j++) {//判断列是否有重复数字
            clear(count);
            for(int i=0;i<9;i++) {
                char c=board[i][j];
                if(c!='.') {
                    count[c-'0']++;
                    if(count[c-'0']>=2)
                        return false;
                }	
            }	
        }

        for(int i=0;i<7;i=i+3) {//判断九宫格是否有重复数字
              for(int j=0;j<7;j=j+3) {
                clear(count);
                for(int r=i;r<i+3;r++) {
                    for(int l=j;l<j+3;l++) {
                        char c=board[r][l];
                        if(c!='.') {
                            count[c-'0']++;
                            if(count[c-'0']>=2)
                                return false;
                        }	
                    }	
                }
            }
        }

        return true;    
    }
    
    private static void clear(int[] nums) {
        for(int i=0;i<nums.length;i++)
            nums[i]=0;
    }
}