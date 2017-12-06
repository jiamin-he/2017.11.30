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
        char[] equation = s.toCharArray();
        int prvSum = 0, prvVal = 0, curVal = 0;
        
        for(int i = 0; i < equation.length; i++){
            if(Character.isDigit(equation[i])){
                while(i< equation.length && Character.isDigit(equation[i])){
                    curVal = curVal*10 + (equation[i]-'0');
                    i++;
                }
                if(curOp.equals('+')){
                    prvSum += prvVal;
                    prvVal = curVal;
                }
                if(curOp.equals('-')){
                    prvSum += prvVal;
                    prvVal = (-curVal);
                }
                if(curOp.equals('*')){
                    prvVal *= curVal;
                }
                if(curOp.equals('/')){
                    prvVal /= curVal;
                }
                curVal = 0;
                i--;
            }
            else if(equation[i] == '+' || equation[i] == '-' || equation[i] == '*' || equation[i] == '/'){
                curOp = equation[i];
            }
        }
    
        return (prvSum+prvVal);
    }
}