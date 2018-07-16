/*
Author: Jiamin
Date: Jan 03, 2017
Problem: evaluate division
Difficulty: medium

Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
*/

// 3ms 57%
// construct a graph and do dfs to find a path.
// O(V+E)
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<String>> pairs = new HashMap<>();
        HashMap<String, List<Double>> valuesPairs = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if(!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPairs.put(equation[0], new ArrayList<Double>());
            }
            if(!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPairs.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            valuesPairs.get(equation[0]).add(values[i]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPairs.get(equation[1]).add(1/values[i]);
        }
        double[] result = new double[queries.length];
        for(int i = 0; i < result.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0],query[1], pairs, valuesPairs, new HashSet<String>(), 1.0);
            if(result[i] == 0.0) result[i] = -1.0;
        }
        return result;
    }
    
    private double dfs(String start, String end, HashMap<String, List<String>> pairs, HashMap<String, List<Double>> valuesPairs, HashSet<String> set, double value) {
        if(set.contains(start)) return 0.0;
        if(!pairs.containsKey(start)) return 0.0;
        if(start.equals(end)) return value;
        set.add(start);
        
        List<String> adjNodes = pairs.get(start);
        List<Double> weights = valuesPairs.get(start);
        double tmp = 0.0;
        for(int i = 0; i < adjNodes.size(); i++) {
            tmp = dfs(adjNodes.get(i), end, pairs, valuesPairs, set, value*weights.get(i));
            if(tmp != 0.0) {
                break;
            }
        }
        return tmp;
    }
}

///没看呢！！！！

//
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
      Map<String, List<Edge>> map = new HashMap();
      int i = 0;
      for(String[] e: equations){
        List<Edge> edges0 = map.getOrDefault(e[0], new ArrayList());  
        List<Edge> edges1 = map.getOrDefault(e[1], new ArrayList());   
        Edge e0 = new Edge(e[1], values[i]);
        Edge e1 = new Edge(e[0], 1 / values[i]);
        edges0.add(e0);
        edges1.add(e1);
        map.put(e[0], edges0);
        map.put(e[1], edges1);
        i++;
      }
      
      double[] res = new double[queries.length];
      for(i = 0; i < queries.length; i++){
        String s = queries[i][0];
        String t = queries[i][1];
        Set<String> visited = new HashSet();
        visited.add(s);
        res[i] = helper(map, visited, s, t, 1.0);
      } 
      return res; 
    }
    
    double helper(Map<String, List<Edge>> map, Set<String> visited, String s, String t, double dis){
       
       if(!map.containsKey(s)){
         return -1.0;
       }
       if(s.equals(t)){
         return dis;
       }
       
       List<Edge> edges = map.get(s);
       for(Edge e: edges){
         if(!visited.contains(e.to)){
           visited.add(e.to);
           double res = helper(map, visited, e.to, t, dis * e.weight);
           if(res != -1.0){
             return res;
           }
         }
       }
       return -1.0;
    }
    
    class Edge{
      double weight;
      String to;
      Edge(String t, double w){
        weight = w;
        to = t;  
      }  
    }
}


//
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String, Double>>();
        for (int i = 0; i < equations.length; ++i) {
            if (!map.containsKey(equations[i][0]))
                map.put(equations[i][0], new HashMap<String, Double>());
            if (!map.containsKey(equations[i][1]))
                map.put(equations[i][1], new HashMap<String, Double>());
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }
        double[] out = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            if (map.containsKey(queries[i][0]) && map.containsKey(queries[i][1])) {
                if (queries[i][0] == queries[i][1])
                    out[i] = 1.0;
                else {
                    double judg = dfs(queries[i][0], queries[i][1], new HashSet<String>(), map, 1.0);
                    out[i] = judg == 0.0 ? -1.0 : judg;
                }
            }
            else out[i] = -1.0;
        }
        return out;
    }
    
    private double dfs(String s, String t, HashSet<String> visited, HashMap<String, HashMap<String, Double>> map, double val) {
        if (map.get(s).containsKey(t)) 
            return val * map.get(s).get(t);
        double tmp = 0.0;
        for (String neighbor : map.get(s).keySet()) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                tmp = dfs(neighbor, t, visited, map, val * map.get(s).get(neighbor));
                if (tmp != 0.0) break;
            }
        }
        return tmp;
    }
}


//
public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        double[] result = new double[query.length];
        // filter unexpected words
        // 过滤掉没有遇见过的字符
        Set<String> words = new HashSet<>();
        for (String[] strs : equations) {
            words.add(strs[0]);
            words.add(strs[1]);
        }
        for (int i = 0; i < query.length; ++i) {
            String[] keys = query[i];
            if (!words.contains(keys[0]) || !words.contains(keys[1])) result[i] = -1.0d;
            else {
                Stack<Integer> stack = new Stack<>();
                result[i] = helper(equations, values, keys, stack);
            }
        }
        return result;
    }

    public double helper(String[][] equations, double[] values, String[] keys, Stack<Integer> stack) {
        // 直接查找，key的顺序有正反
        // look up equations directly
        for (int i = 0; i < equations.length; ++i) {
            if (equations[i][0].equals(keys[0]) && equations[i][1].equals(keys[1])) return values[i];
            if (equations[i][0].equals(keys[1]) && equations[i][1].equals(keys[0])) return 1 / values[i];
        }
        // lookup equations by other equations
        // 间接查找，key的顺序也有正反
        for (int i = 0; i < equations.length; ++i) {
            if (!stack.contains(i) && keys[0].equals(equations[i][0])) {
                stack.push(i);
                double temp = values[i] * helper(equations, values, new String[]{equations[i][1], keys[1]}, stack);
                if (temp > 0) return temp;
                else stack.pop();
            }
            if (!stack.contains(i) && keys[0].equals(equations[i][1])) {
                stack.push(i);
                double temp = helper(equations, values, new String[]{equations[i][0], keys[1]}, stack) / values[i];
                if (temp > 0) return temp;
                else stack.pop();
            }
        }
        // 查不到，返回-1
        return -1.0d;
    }
update:

Thanks for @jason88628 remind me. change from stack to set will be better.

update:

Another way for this problem, but it need more memory and more time to build a whole map of equations.

It’s efficient when there is a large set of queries.

public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        // use table save string to integer
        Map<String, Integer> table = new HashMap<>();
        int len = 0;
        for (String[] strings : equations)
            for (String string : strings)
                if (!table.containsKey(string)) table.put(string, len++);

        // init map by direct equation
        double[][] map = new double[len][len];
        for (int i = 0; i < len; ++i)
            for (int j = 0; j < len; ++j)
                map[i][j] = (i == j ? 1.0d : -1.0d);
        for (int i = 0; i < equations.length; ++i) {
            String[] keys = equations[i];
            int row = table.get(keys[0]);
            int col = table.get(keys[1]);
            map[row][col] = values[i];
            map[col][row] = 1 / values[i];
        }

        // floyd-warshall like algorithm
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                for (int k = 0; k < len; ++k) {
                    if (map[j][i] >= 0d && map[i][k] >= 0d) map[j][k] = map[j][i] * map[i][k];
                }
            }
        }

        // query now
        double[] result = new double[query.length];
        for (int i = 0; i < query.length; ++i) {
            String[] keys = query[i];
            Integer row = table.get(keys[0]);
            Integer col = table.get(keys[1]);
            if (row == null || col == null) result[i] = -1.0d;
            else result[i] = map[row][col];
        }
        return result;
    }
update:
A better way with union-find alogrithm. It takes less memory and time than the above one. But it’s hard to understand.

You can replace class Node with two arrays. In that way, it will be more efficient.

public double[] calcEquation(String[][] equations, double[] values, String[][] query) {

        // map string to integer
        Map<String, Integer> mIdTable = new HashMap<>();
        int len = 0;
        for (String[] words : equations)
            for (String word : words)
                if (!mIdTable.containsKey(word)) mIdTable.put(word, len++);

        // init parent index and value
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; ++i) nodes[i] = new Node(i);

        // union, you can take an example as follows
        // (a/b=3)->(c/d=6)->(b/d=12)
        for (int i = 0; i < equations.length; ++i) {
            String[] keys = equations[i];
            int k1 = mIdTable.get(keys[0]);
            int k2 = mIdTable.get(keys[1]);
            int groupHead1 = find(nodes, k1);
            int groupHead2 = find(nodes, k2);
            nodes[groupHead2].parent = groupHead1;
            nodes[groupHead2].value = nodes[k1].value * values[i] / nodes[k2].value;
        }

        // query now
        double[] result = new double[query.length];
        for (int i = 0; i < query.length; ++i) {
            Integer k1 = mIdTable.get(query[i][0]);
            Integer k2 = mIdTable.get(query[i][1]);
            if (k1 == null || k2 == null) result[i] = -1d;
            else {
                int groupHead1 = find(nodes, k1);
                int groupHead2 = find(nodes, k2);
                if (groupHead1 != groupHead2) result[i] = -1d;
                else result[i] = nodes[k2].value / nodes[k1].value;
            }
        }
        return result;
    }

    public int find(Node[] nodes, int k) {
        int p = k;
        while (nodes[p].parent != p) {
            p = nodes[p].parent;
            // compress
            nodes[k].value *= nodes[p].value;
        }
        // compress
        nodes[k].parent = p;
        return p;
    }

    private static class Node {
        int    parent;
        double value;

        public Node(int index) {
            this.parent = index;
            this.value = 1d;
        }
    }