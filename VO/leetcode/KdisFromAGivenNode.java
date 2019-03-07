//https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
package leetcode;

import apple.laf.JRSUIUtils;

import java.util.*;

public class KdisFromAGivenNode {
    static List<Integer> res = new ArrayList<>();
    public static List<Integer> getValue(TreeNode root, int target, int k) {
        if (root == null) {
            return res;
        }
        HashMap<TreeNode, ArrayList<TreeNode>> map = new HashMap<>();
        getGraph(root, map, null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : map.keySet()) {
            if (node.val == target) {
                q.add(node);
                set.add(node);
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    if (k == 0) {
                        res.add(node.val);
                    }
                    for (TreeNode neigh : map.get(node)) {
                        if (!set.contains(neigh)) {
                            set.add(neigh);
                            q.add(neigh);
                        }
                    }
                }

            }
            k--;
        }
        return res;
    }

    private static void getGraph(TreeNode root, HashMap<TreeNode, ArrayList<TreeNode>> map, TreeNode parent) {
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<TreeNode>());
        }
        map.get(root).add(parent);
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.get(root).add(root.left);
            parent = root;
            getGraph(root.left, map, parent);
        }
        if (root.right != null) {
            map.get(root).add(root.right);
            parent = root;
            getGraph(root.right, map, parent);
        }
        return;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        int target = 14;
        int k = 3;
        List<Integer> res = getValue(root, target, k);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
