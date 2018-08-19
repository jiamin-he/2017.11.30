/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 12, 2018
 Problem:    Number Of Corner Rectangles
 Difficulty: Medium
 Notes:
Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.

 

Example 1:

Input: grid = 
[[1, 0, 0, 1, 0],
 [0, 0, 1, 0, 1],
 [0, 0, 0, 1, 0],
 [1, 0, 1, 0, 1]]
Output: 1
Explanation: There is only one corner rectangle, with corners grid[1][2], grid[1][4], grid[3][2], grid[3][4].
 

Example 2:

Input: grid = 
[[1, 1, 1],
 [1, 1, 1],
 [1, 1, 1]]
Output: 9
Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and one 3x3 rectangle.
 

Example 3:

Input: grid = 
[[1, 1, 1, 1]]
Output: 0
Explanation: Rectangles must have four distinct corners.
 

Note:

The number of rows and columns of grid will each be in the range [1, 200].
Each grid[i][j] will be either 0 or 1.
The number of 1s in the grid will be at most 6000.
*/

class Solution {
	private int getValue(String ip) {
		
		int ans = 0;
		String[] strs = ip.split("[.]");
		for (String string : strs) {
			int temp = Integer.parseInt(string);
			ans = ans * 256 + temp;
		}
		return ans;
		
	}
	
	private String getString(int value , int bit) {
		
		StringBuilder builder = new StringBuilder();
		for (int i = 31;i >= 0;i -= 8) {
			int temp = 0;
			for (int j = i;j >= i - 7;j --) {
				if ((value & (1 << j)) != 0) {
					temp = temp * 2 + 1;
				} else {
					temp *= 2;
				}
			}
			if (builder.length() > 0) {
				builder.append(".");
			}
			builder.append(temp);
		}
		builder.append("/");
		builder.append(bit);
		return builder.toString();
		
	}
	
    public List<String> ipToCIDR(String ip, int range) {
        
    	int start = getValue(ip);
    	List<String> ans = new ArrayList<>();
    	for (int i = start;i <= start + range - 1;i ++) {
    		if ((i & (1 << 0)) != 0) {
    			ans.add(getString(i , 32));
    		} else {
    			int originI = i;
    			int j = 0;
    			while (j < 32 && (i & (1 << j)) == 0) {
    				j ++;
    			}
    			if (j == 32) {
    				j --;
    			}
    			while (j >= 0) {
    				int temp = i + (1 << j) - 1;
    				if (temp <= start + range - 1) {
    					i = temp;
    					break;
    				}
    				j --;
    			}
    			ans.add(getString(originI , 32 - j));
    		}
    	}
    	return ans;
    	
    }
}



public List<String> ipToCIDR(String ip, int range) {
		long x = 0;
		String[] ips = ip.split("\\.");
		for (int i = 0; i < ips.length; ++i) {
			x = Integer.parseInt(ips[i]) + x * 256;
		}
		
		List<String> ans = new ArrayList<>();
		while (range > 0) {
			long step = x & -x;
			while (step > range) step /= 2;
			ans.add(longToIP(x, (int)step));
			x += step;
			range -= step;
		}
		
		return ans;
	}
	
	String longToIP(long x, int step) {
		int[] ans = new int[4];
		ans[0] = (int) (x & 255); x >>= 8;
		ans[1] = (int) (x & 255); x >>= 8;
		ans[2] = (int) (x & 255); x >>= 8;
		ans[3] = (int) x;
		int len = 33;
		while (step > 0) {
			len --;
			step /= 2;
		}
		return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;
	}



	class Solution {
    public List<String> ipToCIDR(String ipString, int range) {
        int ip = convertStringIPtoNum(ipString);        
        List<String> cidrBlocks = new ArrayList<>();
        while(range > 0) {
            int zeros = getZeros(ip);
            int thisRange = 1 << zeros;
            thisRange = Math.min(range,thisRange);
            getCidrBlocks(ip, thisRange, cidrBlocks);
            ip += thisRange;
            range -= thisRange;
        }
        return cidrBlocks;
    }
    
    private int getZeros(int ip) {
        int zeros = 0;
        for(int i = 0; i<32; i++) {
            if((ip & (1 << i)) == 0) {
                zeros++;
            } else break;
        }
        return zeros;
    }
    
    private void getCidrBlocks(int ip, int range, List<String> cidrBlocks) {
        if(range <= 0) return;
        int i = 0;
        while((1 << i+1) <= range) i++; // Get power of 2 within range
        int prefixLength = 32-i;
        int thisRange = 1 << i;
        String ipString = convertNumToIPString(ip) + "/" + prefixLength;
        cidrBlocks.add(ipString);
        getCidrBlocks(ip+thisRange,range-thisRange,cidrBlocks);        
    }
    
    private String convertNumToIPString(int num) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<4; i++) {
            if(i>0) sb.insert(0, '.');
            sb.insert(0,(num & 255));
            num >>= 8;
        }
        return sb.toString();
    }
    
    private int convertStringIPtoNum(String ipstring) {
	String[] ipArray = ipstring.split("[.]");
	int ip = 0;
	for(int i=0; i<4; i++) {
	    ip += Integer.parseInt(ipArray[i]) * (1 << (8*(3-i)));
	}
	return ip;
    }
}