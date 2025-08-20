public class RBValidationExercise {
    enum Color { RED, BLACK }

    static class Node {
        int val;
        Color color;
        Node left, right;
        Node(int val, Color color) {
            this.val = val;
            this.color = color;
        }
    }

    public static boolean isValidRBTree(Node root) {
        if (root == null) return true;
        if (root.color != Color.BLACK) {
            System.out.println("根節點不是黑色");
            return false;
        }
        return validate(root) != -1;
    }

    private static int validate(Node node) {
        if (node == null) return 1;
        Node left = node.left;
        Node right = node.right;

        int leftBlackHeight = validate(left);
        int rightBlackHeight = validate(right);
        if (leftBlackHeight == -1 || rightBlackHeight == -1) return -1;

        if (leftBlackHeight != rightBlackHeight) {
            System.out.println("黑高度不一致於節點 " + node.val);
            return -1;
        }

        if (node.color == Color.RED) {
            if ((left != null && left.color == Color.RED) || (right != null && right.color == Color.RED)) {
                System.out.println("紅色節點有紅色子節點於節點 " + node.val);
                return -1;
            }
        }

        return leftBlackHeight + (node.color == Color.BLACK ? 1 : 0);
    }

    public static void main(String[] args) {
        Node root = new Node(10, Color.BLACK);
        root.left = new Node(5, Color.RED);
        root.right = new Node(15, Color.RED);
        System.out.println(isValidRBTree(root));
    }
}
