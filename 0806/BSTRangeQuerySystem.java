import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class BSTRangeQuerySystem {
    public List<Integer> rangeQuery(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        dfsRange(root, min, max, res);
        return res;
    }

    private void dfsRange(TreeNode node, int min, int max, List<Integer> res) {
        if (node == null) return;
        if (node.val > min) dfsRange(node.left, min, max, res);
        if (node.val >= min && node.val <= max) res.add(node.val);
        if (node.val < max) dfsRange(node.right, min, max, res);
    }

    public int rangeCount(TreeNode root, int min, int max) {
        return rangeQuery(root, min, max).size();
    }

    public int rangeSum(TreeNode root, int min, int max) {
        return rangeQuery(root, min, max).stream().mapToInt(i -> i).sum();
    }

    public int closestValue(TreeNode root, int target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }
}