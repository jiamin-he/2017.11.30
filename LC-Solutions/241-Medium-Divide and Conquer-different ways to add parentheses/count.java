/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 22, 2017
 Problem:    Different Ways to Add Parentheses
 Difficulty: Medium
 Notes:

Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]

*/

// 11ms 5%
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        boolean flag = false;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '+' ||input.charAt(i) == '-' || input.charAt(i) == '*') {
                flag = true;
                l1 = diffWaysToCompute(input.substring(0,i));
                l2 = diffWaysToCompute(input.substring(i+1));
                if (input.charAt(i) == '+') {
                    res.addAll(conquerAdd(l1,l2));
                } else if (input.charAt(i) == '-') {
                    res.addAll(conquerMin(l1,l2));
                } else if (input.charAt(i) == '*') {
                    res.addAll(conquerMul(l1,l2));
                }   
            }
        }
        if(!flag) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
    
    public List<Integer> conquerAdd(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        for(Integer i: l1) {
            for (Integer j: l2) {
                res.add(i+j);
            }
        }
        return res;
    }
    
    public List<Integer> conquerMin(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        for(Integer i: l1) {
            for (Integer j: l2) {
                res.add(i-j);
            }
        }
        return res;
    }
    
    public List<Integer> conquerMul(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        for(Integer i: l1) {
            for (Integer j: l2) {
                res.add(i*j);
            }
        }
        return res;
    }
}


// if don't use this helper functions
// same idea
// 8ms 22%
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }
}

// notice, there are many duplicate cases in the computation
// so we use a map to store it. <String input, List<..> value>
// efficient!
// 2ms 98%
class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i ++) {
            char op = input.charAt(i);
            if(op == '+' || op == '-' || op == '*'){ 
                List<Integer> l = diffWaysToCompute(input.substring(0, i));
                List<Integer> r = diffWaysToCompute(input.substring(i + 1));
                for(int t1 : l) {
                    for(int t2 : r) {
                        if(op == '+')
                            res.add(t1 + t2);
                        else if(op == '-')
                            res.add(t1 - t2);
                        else 
                            res.add(t1 * t2);
                    }
                }
            }
        }
        if(res.size() == 0)
            res.add(Integer.parseInt(input));
        map.put(input, res);
        return res;
    }
}