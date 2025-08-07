public class BSTValidationAndRepair {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

    TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        first = second = prev = null;
        inorder(root);
        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) first = prev;
            second = node;
        }
        prev = node;
        inorder(node.right);
    }

    public int minRemovalsToValidBST(TreeNode root) {
        return countInvalidNodes(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private int countInvalidNodes(TreeNode node, long min, long max) {
        if (node == null) return 0;
        if (node.val <= min || node.val >= max)
            return 1 + countAllNodes(node.left) + countAllNodes(node.right);
        return countInvalidNodes(node.left, min, node.val) + countInvalidNodes(node.right, node.val, max);
    }

    private int countAllNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countAllNodes(node.left) + countAllNodes(node.right);
    }
}
