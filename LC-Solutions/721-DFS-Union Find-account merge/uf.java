
/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 05, 2017
 Problem:    Accounts Merge
 Difficulty: Medium
 Notes:

Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].

*/

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                String p = find(a.get(i), parents);
                if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
                unions.get(p).add(a.get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}


///
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts==null || accounts.size()<1){
            return new ArrayList<>();
        }
        int[] parent = new int[accounts.size()];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            List<String> eleStrs = accounts.get(i);
            for(int j=1;j<eleStrs.size();j++){
                String email = eleStrs.get(j);
                if(map.containsKey(email)){
                    int pre_id = map.get(email);
                    int cur_id = i;
                    int parent_pre_id = findParent(parent,pre_id);
                    int parent_cur_id = findParent(parent,cur_id);
                    if(parent_pre_id!=parent_cur_id){
                        parent[parent_cur_id] = parent_pre_id;
                    }
                }else{
                    map.put(email,i);
                }
            }
        }
        
        Map<Integer,Set<String>> hm = new HashMap<>();
        for(int i=0;i<parent.length;i++){
            int index = findParent(parent,i);
            if(!hm.containsKey(index)){
                hm.put(index,new HashSet<>());
            }
            
            Set<String> temp = new HashSet<>();
            for(int j=1;j<accounts.get(i).size();j++){
                temp.add(accounts.get(i).get(j));
            }
            hm.get(index).addAll(temp);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(Integer id : hm.keySet()){
            ans.add(new ArrayList<>());
            ans.get(ans.size()-1).add(accounts.get(id).get(0));
            
            List<String> addemails = new ArrayList<>(hm.get(id));
            Collections.sort(addemails);
            ans.get(ans.size()-1).addAll(addemails);
        }
        
        return ans;
        
    }
    
    public int findParent(int[] parent,int index){
             while(index!=parent[index]){
                 parent[index] = parent[parent[index]];
                 index = parent[index];
             }
        
             return index;
    }
}
