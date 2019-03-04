class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode res = new TreeNode(-1);
        int count = 0;
        TreeNode q = root;
        while (!stack.isEmpty() || q != null) {
            if (q != null) {
                stack.push(q);
                q = q.left;
            } else {
                res = stack.pop();
                count++;
                if (count == k) {
                    break;
                }
                q = res.right;
            }
        }
        return res.val;
    }
}