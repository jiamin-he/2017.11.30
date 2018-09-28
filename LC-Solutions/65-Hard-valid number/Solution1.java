/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 25, 2018
 Problem:    valid number
 Difficulty: hard
 Notes:
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
*/

class Solution {
    public boolean isNumber(String s) {
        char[] sc = s.trim().toCharArray();
        int i = 0;
        boolean operand = false, exp = false, point = false, expVal = false, val = false;
        while(i < sc.length) {
            if(Character.isDigit(sc[i])) {
                while(i < sc.length && Character.isDigit(sc[i])){
                    i++;
                }
                i--;
                if(exp) {
                    expVal = true;
                } else {
                    val = true;
                }
            } else if (sc[i] == 'e') {
                if(exp) return false;
                else {
                    exp = true;
                    operand = false;
                    point = false;
                }
            } else if (sc[i] == '.') {
                if(point || exp) return false;
                else {
                    point = true;
                }
            } else if (sc[i] == '+' || sc[i] == '-') {
                if(operand) return false;
                else {
                    operand = true;
                }
                if(!exp && val) return false;
                if(exp && expVal) return false;
                if(point) return false;
            } else {
                return false;
            }
            i++;
        }
        if(exp && !expVal) return false;
        if(!val) return false;
        return true;
    }
}