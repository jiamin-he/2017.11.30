/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 25, 2017
 Problem:    Basic Calculator II
 Difficulty: medium
 Notes:

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/

class Solution {
    public int calculate(String s) {
        Character curOp = '+';
        Stack<Integer> val = new Stack<>();
        char[] equation = s.toCharArray();
        int tempSum = 0;
        for(int i = 0; i < equation.length; i++){
            if(Character.isDigit(equation[i])){
                while(i< equation.length && Character.isDigit(equation[i])){
                    tempSum = tempSum*10 + (equation[i]-'0');
                    i++;
                }
                if(curOp.equals('+')){
                    val.push(tempSum);
                }
                if(curOp.equals('-')){
                    val.push(-tempSum);
                }
                if(curOp.equals('*')){
                    int temp = val.pop();
                    val.push(temp*tempSum);
                }
                if(curOp.equals('/')){
                    int temp = val.pop();
                    val.push(temp/tempSum);
                }
                tempSum = 0;
                i--;
            }
            else if(equation[i] == '+' || equation[i] == '-' || equation[i] == '*' || equation[i] == '/'){
                curOp = equation[i];
            }
        }
        
        int res = 0;
        while(!val.empty()){
            res += val.pop();
            
        }
        
        return res;
    }
}