import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) result.add(new ArrayList<>(path));
        dfs(node.left, path, result);
        dfs(node.right, path, result);
        path.remove(path.size() - 1);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public int maxRootToLeafSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + Math.max(maxRootToLeafSum(root.left), maxRootToLeafSum(root.right));
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathHelper(root);
        return maxSum;
    }

    private int maxPathHelper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathHelper(node.left));
        int right = Math.max(0, maxPathHelper(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);
        return node.val + Math.max(left, right);
    }
}
