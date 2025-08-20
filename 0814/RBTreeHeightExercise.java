public class RBTreeHeightExercise {
    enum Color { RED, BLACK }

    static class Node {
        int val;
        Color color;
        Node left, right;
        Node(int val, Color color) { this.val = val; this.color = color; }
    }

    static class RBTree {
        Node root;

        int height(Node node) {
            if (node == null) return 0;
            return 1 + Math.max(height(node.left), height(node.right));
        }

        int blackHeight(Node node) {
            if (node == null) return 1;
            int leftBH = blackHeight(node.left);
            int rightBH = blackHeight(node.right);
            if (leftBH != rightBH) throw new RuntimeException("紅黑樹黑高度不一致");
            return leftBH + (node.color == Color.BLACK ? 1 : 0);
        }
    }
}
