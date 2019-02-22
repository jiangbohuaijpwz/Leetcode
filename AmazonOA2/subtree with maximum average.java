//lintcode 596
import java.io.*;
import java.util.*;
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    private class ResultType {
        int sum;
        int size;
        TreeNode node;
        public ResultType(int sum, int size, TreeNode node) {
            this.sum = sum;
            this.size = size;
            this.node = node;
        }
    }
    private ResultType res = new ResultType(0, 0, null);
    
    public TreeNode findSubtree2(TreeNode root) {
        // if (root == null) {
        //     return null;
        // }
        helper(root);
        return res.node;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0,0,null);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType curResult = new ResultType(left.sum + right.sum + root.val, left.size + right.size + 1, root);
        if (res.node == null || curResult.sum * res.size > curResult.size * res.sum ) {
            res = curResult;
        }
        return curResult;
    }
}
