/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Dec 20, 2017
 Problem:    Construct String from Binary Tree
 Difficulty: Easy
 Notes:
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
Example 2:
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example, 
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

*/


// 改进前
// 55ms 5%
class Solution {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        StringBuilder sb = new StringBuilder();
        return tree2str(t,sb);
    }
    public String tree2str(TreeNode t, StringBuilder sb) {
        sb.append(t.val);
        if(t.left != null) {
            sb.append("(");
            tree2str(t.left,sb);
            sb.append(")");
            if(t.right != null) {
                sb.append("(");
                tree2str(t.right,sb);
                sb.append(")");
            }
        } else if(t.right != null) {
            sb.append("()(");
            tree2str(t.right,sb);
            sb.append(")");
        }
        return sb.toString();
    }
}

// 改进后 （把重复的程序改写了一下 使得代码结构好了一点）
// 48ms 9%
class Solution {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        StringBuilder sb = new StringBuilder();
        return tree2str(t,sb);
    }
    public String tree2str(TreeNode t, StringBuilder sb) {
        sb.append(t.val);
        if(t.right != null) {
            print(t.left,sb);
            print(t.right,sb);
        } else if(t.left != null) {
            print(t.left,sb);
        }
        return sb.toString();
    }
    public void print(TreeNode t, StringBuilder sb) {
        if(t == null) sb.append("()");
        else {
            sb.append("(");
            tree2str(t,sb);
            sb.append(")");
        }
    }
}

// 再改进
// 跟我的第一版本相比 关键在于把return 类型 string 改成void！！！
// 因为根本没有必要在helper函数每次返回一个string 把stringbuilder改成string也是很浪费时间的！
// 最后再对stringbuilder来转string 只转一次 才是正道
class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(sb,t);
        return sb.toString();
    }
    public void helper(StringBuilder sb,TreeNode t){
        if(t!=null){
            sb.append(t.val);
            if(t.left!=null||t.right!=null){
                sb.append("(");
                helper(sb,t.left);
                sb.append(")");
                if(t.right!=null){
                    sb.append("(");
                    helper(sb,t.right);
                    sb.append(")");
                }
            }
        }
    }
}