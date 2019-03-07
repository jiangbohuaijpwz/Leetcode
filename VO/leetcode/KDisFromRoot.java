//https://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
package leetcode;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}
public class KDisFromRoot {
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> getValue (TreeNode root, int distance) {
        if (root == null) {
            return res;
        }
        dfs(root, distance, 0);
        return res;
    }

    private static void dfs(TreeNode root, int distance, int k) {
        if (root == null) {
            return;
        }
        if (k == distance) {
            res.add(root.val);
        }
        dfs(root.left, distance, k + 1);
        dfs(root.right, distance, k + 1);
        return;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        List<Integer> res = getValue(root, 2);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
