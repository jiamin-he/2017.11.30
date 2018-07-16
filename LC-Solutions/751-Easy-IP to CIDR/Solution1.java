/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 23, 2017
 Problem:    IP to CIDR
 Difficulty: Easy
 Notes:
Given a start IP address ip and a number of ips we need to cover n, return a representation of the range as a list (of smallest possible length) of CIDR blocks.

A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length. For example: "123.45.67.89/20". That prefix length "20" represents the number of common prefix bits in the specified range.

Example 1:
Input: ip = "255.0.0.7", n = 10
Output: ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
Explanation:
The initial ip address, when converted to binary, looks like this (spaces added for clarity):
255.0.0.7 -> 11111111 00000000 00000000 00000111
The address "255.0.0.7/32" specifies all addresses with a common prefix of 32 bits to the given address,
ie. just this one address.

The address "255.0.0.8/29" specifies all addresses with a common prefix of 29 bits to the given address:
255.0.0.8 -> 11111111 00000000 00000000 00001000
Addresses with common prefix of 29 bits are:
11111111 00000000 00000000 00001000
11111111 00000000 00000000 00001001
11111111 00000000 00000000 00001010
11111111 00000000 00000000 00001011
11111111 00000000 00000000 00001100
11111111 00000000 00000000 00001101
11111111 00000000 00000000 00001110
11111111 00000000 00000000 00001111

The address "255.0.0.16/32" specifies all addresses with a common prefix of 32 bits to the given address,
ie. just 11111111 00000000 00000000 00010000.

In total, the answer specifies the range of 10 ips starting with the address 255.0.0.7 .

There were other representations, such as:
["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
but our answer was the shortest possible.

Also note that a representation beginning with say, "255.0.0.7/30" would be incorrect,
because it includes addresses like 255.0.0.4 = 11111111 00000000 00000000 00000100 
that are outside the specified range.
Note:
ip will be a valid IPv4 address.
Every implied address ip + x (for x < n) will be a valid IPv4 address.
n will be an integer in the range [1, 1000].
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