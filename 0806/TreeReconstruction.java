import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode buildPreIn(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe) return null;
        TreeNode root = new TreeNode(pre[ps]);
        int idx = map.get(pre[ps]);
        int leftSize = idx - is;
        root.left = buildPreIn(pre, ps + 1, ps + leftSize, in, is, idx - 1, map);
        root.right = buildPreIn(pre, ps + leftSize + 1, pe, in, idx + 1, ie, map);
        return root;
    }

    public TreeNode buildTreePostIn(int[] post, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return buildPostIn(post, 0, post.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode buildPostIn(int[] post, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe) return null;
        TreeNode root = new TreeNode(post[pe]);
        int idx = map.get(post[pe]);
        int leftSize = idx - is;
        root.left = buildPostIn(post, ps, ps + leftSize - 1, in, is, idx - 1, map);
        root.right = buildPostIn(post, ps + leftSize, pe - 1, in, idx + 1, ie, map);
        return root;
    }

    public TreeNode buildFromLevelOrder(int[] level) {
        if (level.length == 0) return null;
        TreeNode root = new TreeNode(level[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < level.length) {
            TreeNode node = q.poll();
            if (i < level.length) node.left = new TreeNode(level[i++]);
            if (i < level.length) node.right = new TreeNode(level[i++]);
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        return root;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
