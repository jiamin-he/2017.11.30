/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Aug 25, 2018
 Problem:    Validate IP Address
 Difficulty: Medium
 Notes:

Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Note: You may assume there is no extra space or special characters in the input string.

Example 1:
Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:
Input: "256.256.256.256"

Output: "Neither"

Explanation: This is neither a IPv4 address nor a IPv6 address.

*/

// 7ms 30%
class Solution {
    public String validIPAddress(String IP) {
        String v4 = "IPv4", v6 = "IPv6", no = "Neither";
        if(IP == null || IP.length() < 1) return no;
        if(validIPv4(IP)) return v4;
        if(validIPv6(IP)) return v6;
        return no;
    }
    public boolean validIPv4 (String IP) {
        if(IP.charAt(IP.length()-1) == '.') return false;
        String[] parts= IP.split("\\.");
        if(parts.length != 4) return false;
        for(String part: parts) {
            if(part == null || part.length() < 1 || part.charAt(0)=='-' || (part.length() > 1 && part.charAt(0) == '0')) return false;
            // if(Integer.parseInt(part)>255) return false;
            try{
                if(Integer.parseInt(part)>255 || Integer.parseInt(part)< 0) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
    public boolean validIPv6 (String IP) {
        if(IP.charAt(IP.length()-1) == ':') return false;
        String[] parts= IP.split(":");
        if(parts.length != 8) return false;
        for(String part: parts) {
            if(part==null || part.length() < 1 || part.length() > 4 || part.charAt(0) == '-') return false;
            // if(Integer.valueOf(part,16)>65535) return false;
            try{
                if(Integer.valueOf(part,16)>65535 || Integer.valueOf(part,16)<0) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}