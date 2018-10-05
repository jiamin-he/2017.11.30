/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 30, 2018
 Problem:    Frog Jump
 Difficulty: Hard
 Notes:
A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

Note:

The number of stones is ≥ 2 and is < 1,100.
Each stone's position will be a non-negative integer < 231.
The first stone's position is always 0.
Example 1:

[0,1,3,5,6,8,12,17]

There are a total of 8 stones.
The first stone at the 0th unit, second stone at the 1st unit,
third stone at the 3rd unit, and so on...
The last stone at the 17th unit.

Return true. The frog can jump to the last stone by jumping 
1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
2 units to the 4th stone, then 3 units to the 6th stone, 
4 units to the 7th stone, and 5 units to the 8th stone.
Example 2:

[0,1,2,3,4,8,9,11]

Return false. There is no way to jump to the last stone as 
the gap between the 5th and 6th stone is too large.
*/

// memory limit exceed
// bfs
// time O(3^n) space O(3^n)
class Solution {
    class Wrap {
        int stone;
        int k;
        
        public Wrap(int s, int cur_k) {
            stone = s;
            k = cur_k;
        }
    }
    public boolean canCross(int[] stones) {
        int len = stones.length;
        Set<Integer> stoneSet = new HashSet<>();
        int[] dir = new int[]{-1,0,1};
        for(int i = 0; i < len; i++) {
            stoneSet.add(stones[i]);
        }
        if(!stoneSet.contains(1)) return false;
        Queue<Wrap> possibleStones = new ArrayDeque<>();
        possibleStones.offer(new Wrap(1,1));
        int furthest = 0;
        while(!possibleStones.isEmpty()) {
            Wrap cur = possibleStones.poll();
            if(cur.stone > furthest) {
                furthest = cur.stone;
            }
            for(int i = 0; i < dir.length; i++) {
                int val = cur.stone + cur.k + dir[i];
                if(cur.k + dir[i] > 0 && stoneSet.contains(val)) {
                    possibleStones.offer(new Wrap(val, cur.k + dir[i]));
                }
            }
        }
        return furthest >= stones[len-1]; 
    }
}

// 那如果dfs呢？
// time O(3^n) space O(n)--depth of the tree is n
// TLE
public class Solution {
    public boolean canCross(int[] stones) {
        return can_Cross(stones, 0, 0);
    }
    public boolean can_Cross(int[] stones, int ind, int jumpsize) {
        for (int i = ind + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[ind];
            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) {
                if (can_Cross(stones, i, gap)) {
                    return true;
                }
            }
        }
        return ind == stones.length - 1;
    }
}

// using memorization
// coz in dfs/bfs, we would go to the same point that we've visited
// time O(n^3) space O(n^2)
public class Solution {
    public boolean canCross(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return can_Cross(stones, 0, 0, memo) == 1;
    }
    public int can_Cross(int[] stones, int ind, int jumpsize, int[][] memo) {
        if (memo[ind][jumpsize] >= 0) {
            return memo[ind][jumpsize];
        }
        for (int i = ind + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[ind];
            if (gap >= jumpsize - 1 && gap <= jumpsize + 1) {
                if (can_Cross(stones, i, gap, memo) == 1) {
                    memo[ind][gap] = 1;
                    return 1;
                }
            }
        }
        memo[ind][jumpsize] = (ind == stones.length - 1) ? 1 : 0;
        return memo[ind][jumpsize];
    }
}

// dp
// time O(n^2) space O(n^2)
public class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}

// dfs with hashset
class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length < 2) {
        	return false;
        }
        if (stones[0] != 0 || stones[1] != 1) {
        	return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i=2; i<stones.length; i++) {
            if (i>2 && stones[i] > 2*stones[i-1]) {
        		return false;
        	}
        	set.add(stones[i]);
        }
        return dfs(set, 1, 1, stones[stones.length-1]);
    }
	
	private boolean dfs(Set<Integer> set, int unit, int lastMove, int target) {
		if (unit == target) {
			return true;
		}
		for (int i=lastMove+1; i>=lastMove-1; i--) {
			if (i > 0 && set.contains(unit+i) && dfs(set, unit+i, i, target)) {
				return true;
			}
		}
		return false;
	}
}