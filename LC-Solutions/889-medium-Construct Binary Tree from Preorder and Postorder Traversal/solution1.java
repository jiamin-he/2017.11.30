/*
Author: Jiamin
Date: Aug 26, 2018
Problem: Construct Binary Tree from Preorder and Postorder Traversal
Difficulty: medium

Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

 

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
 

Note:

1 <= pre.length == post.length <= 30
pre[] and post[] are both permutations of 1, 2, ..., pre.length.
It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
*/

// 总是算不对！！stack overflow 为什么呢！！
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, post, 0, pre.length-1, 0, post.length-1);
    }
    
    public TreeNode helper(int[] pre, int[] post, int preL, int preR, int postL, int postR) {
        TreeNode root = new TreeNode(pre[preL]);
        if(preL == preR) return root;
        int preLeftL = preL +1;
        int postRightR = postR-1;
        int preLeftR = 0, postRightL = postL, preRightL = preL, preRightR = preR, postLeftL = postL, postLeftR = 0;
        if(postRightR >= 0) {
           for(int i = preL; i<= preR; i++) {
                if(pre[i] == post[postRightR]) {
                    preLeftR = i-1;
                    preRightL = i;
                }
            } 
        }
        if(preLeftL < pre.length) {
           for(int i = postL; i<= postR; i++) {
                if(post[i] == pre[preLeftL]) {
                    postRightL = i+1;
                    postLeftR = i;
                }
            } 
        }
        
        System.out.println(preLeftL +" " +preLeftR +" " +preRightL +" " +preRightR +" " + postLeftL +" " +postLeftR + " " +postRightL + " " +postRightR); 
        root.left = (preLeftL<=preLeftR)? helper(pre,post,preLeftL, preLeftR,postLeftL, postLeftR):null;
        root.right = (preRightL<=preRightR)? helper(pre,post,preRightL, preRightR,postRightL, postRightR):null;
        return root;
    }
}


// 这样也不对！！为什么呢！！！要疯了！！！
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, post, 0, pre.length-1, 0, post.length-1);
    }
    
    public TreeNode helper(int[] pre, int[] post, int preL, int preR, int postL, int postR) {
        TreeNode root;
        if (preL == preR || postL == postR) {
            root = preL==preR? new TreeNode(pre[preL]): new TreeNode(post[postR]);
            return root;
        } else if(preL > preR || postL > postR) return null;
        root = new TreeNode(pre[preL]);
        int preLeftL = preL +1;
        int postRightR = postR-1;
        int preLeftR = 0, postRightL = postL, preRightL = preL, preRightR = preR, postLeftL = postL, postLeftR = 0;
        if(postRightR >= 0) {
           for(int i = preL; i<= preR; i++) {
                if(pre[i] == post[postRightR]) {
                    preLeftR = i-1;
                    preRightL = i;
                }
            } 
        }
        if(preLeftL < pre.length) {
           for(int i = postL; i<= postR; i++) {
                if(post[i] == pre[preLeftL]) {
                    postRightL = i+1;
                    postLeftR = i;
                }
            } 
        }
        root.left = helper(pre,post,preLeftL, preLeftR,postLeftL, postLeftR);
        root.right = helper(pre,post,preRightL, preRightR,postRightL, postRightR);
        return root;
    }
}

// 我的问题在于 当存在多个解的时候 左/右子树的坐标就有可能出现left> right 这种不合理现象，然后两次递归都各自一半坐标不合理 就不ok呀！
// 那如何解决呢？通过设定长度！ 一旦root.left的长度定下来之后，right的子树的长度也是定下来了的！
// 这个是from discuss
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length == 0 || post.length == 0 || pre.length != post.length)
            return null;
        return dfs(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }
    private TreeNode dfs(int[] pre, int ps, int pe, int[] post, int pps, int ppe) {
        if(ps > pe || pps > ppe) return null;
        TreeNode root = new TreeNode(pre[ps]);
        if(ps + 1 > pe) return root;
				// this is the start of the left tree
        int val = pre[ps + 1], idx = pps;
        for(; idx < ppe; idx++) {
            if(post[idx] == val) break;
        }
        root.left = dfs(pre, ps + 1, ps + idx - pps + 1, post, pps, idx);
        root.right = dfs(pre, ps + idx - pps + 2, pe, post, idx + 1, ppe - 1);
        return root;
    }
}

// 和我原先的code修改一下
// 13ms 90%
// O(NlogN) --> it takes already O(N) to find the left part and right part, and recursively would take log N levels.
// so it is O(NlogN)
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, post, 0, pre.length-1, 0, post.length-1);
    }
    
    public TreeNode helper(int[] pre, int[] post, int preL, int preR, int postL, int postR) {
        TreeNode root = null;
        if(preL > preR || postL > postR) return null;
        
        root = new TreeNode(pre[preL]);
        if (preL == preR) {
            return root;
        }
        
        int preLeftL = preL +1, len = 0;
        for(int i = postL; i<= postR; i++) {
            if(post[i] == pre[preLeftL]) {
                len = i-postL+1;
            }
        } 
        int preLeftR = preLeftL+len-1, preRightL = preLeftR+1, preRightR = preR;
        int postLeftL = postL, postLeftR = postLeftL+len-1, postRightL = postLeftR+1, postRightR = postR-1;

        root.left = helper(pre,post,preLeftL, preLeftR,postLeftL, postLeftR);
        root.right = helper(pre,post,preRightL, preRightR,postRightL, postRightR);
        return root;
    }
}

