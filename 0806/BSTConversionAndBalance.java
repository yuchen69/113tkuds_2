public class BSTConversionAndBalance {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    TreeNode prev = null, head = null;

    public TreeNode bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        inorder(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null) {
            prev.right = node;
            node.left = prev;
        } else {
            head = node;
        }
        prev = node;
        inorder(node.right);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) return null;
        int m = (l + r) / 2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = build(nums, l, m - 1);
        node.right = build(nums, m + 1, r);
        return node;
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    public void convertToGreaterTree(TreeNode root) {
        int[] sum = new int[1];
        reverseInorder(root, sum);
    }

    private void reverseInorder(TreeNode node, int[] sum) {
        if (node == null) return;
        reverseInorder(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        reverseInorder(node.left, sum);
    }
}
