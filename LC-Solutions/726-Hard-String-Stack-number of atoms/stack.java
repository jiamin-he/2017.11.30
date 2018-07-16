/*
Author: Jiamin
Date: Jan 04, 2017
Problem: number of atoms
Difficulty: hard
Given a chemical formula (given as a string), return the count of each atom.

An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.

Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

Example 1:
Input: 
formula = "H2O"
Output: "H2O"
Explanation: 
The count of elements are {'H': 2, 'O': 1}.
Example 2:
Input: 
formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation: 
The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
Example 3:
Input: 
formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
Explanation: 
The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
Note:

All atom names consist of lowercase letters, except for the first character which is uppercase.
The length of formula will be in the range [1, 1000].
formula will only consist of letters, digits, and round parentheses, and is a valid formula as defined in the problem.

*/

// 13ms 61%
class Solution {
    public String countOfAtoms(String formula) {
        Deque<HashMap<String, Integer>> stack = new ArrayDeque<>();
        char[] sc = formula.toCharArray();
        int len = sc.length;
        for(int i =0; i < len;) {
            char c = sc[i];
            if(c == '(') {
                stack.push(new HashMap<String,Integer>());
                i++;
            } else if (c == ')') {
                HashMap<String, Integer> cur = stack.pop();
                // empty? hints. (i did not consider this.)
                if(stack.isEmpty()) stack.push(new HashMap<String,Integer>());
                HashMap<String, Integer> peek = stack.peek();
                int iStart = ++i;
                while(i< len && Character.isDigit(sc[i])) i++;
                int multi = i==iStart? 1: Integer.parseInt(formula.substring(iStart,i));
                for(String n: cur.keySet()) {
                    peek.put(n, peek.getOrDefault(n,0) + multi*cur.get(n)); 
                }
            } else {
                // this part hints.
                int iStart = i;
                while (i< len -1 && Character.isLowerCase(sc[i+1])) i++;
                String name = formula.substring(iStart, i+1);
                iStart = ++i;
                while(i< len && Character.isDigit(sc[i])) i++;
                int value = i==iStart? 1:Integer.parseInt(formula.substring(iStart,i));
                if(stack.isEmpty()) stack.push(new HashMap<String,Integer>());
                HashMap<String, Integer> cur = stack.peek();
                cur.put(name,cur.getOrDefault(name,0) + value);
            }
        }
        
        HashMap<String, Integer> cur = stack.peek();
        // this sort, hints.
        List<String> list = new ArrayList(cur.keySet());
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String name: list) {
            sb.append(name);
            if(cur.get(name) > 1) sb.append(cur.get(name));
        }
        return sb.toString();
    }
}