public class RBDeleteFixupExercise {
    enum Color { RED, BLACK }

    static class Node {
        int val;
        Color color;
        Node left, right, parent;
        Node(int val) { this.val = val; this.color = Color.RED; }
    }

    static class RBTree {
        Node root;

        void delete(int val) {
            Node node = search(root, val);
            if (node == null) return;
            Node y = node;
            Color originalColor = y.color;
            Node x;
            if (node.left == null) {
                x = node.right;
                transplant(node, node.right);
            } else if (node.right == null) {
                x = node.left;
                transplant(node, node.left);
            } else {
                y = minimum(node.right);
                originalColor = y.color;
                x = y.right;
                if (y.parent == node) {
                    if (x != null) x.parent = y;
                } else {
                    transplant(y, y.right);
                    y.right = node.right;
                    y.right.parent = y;
                }
                transplant(node, y);
                y.left = node.left;
                y.left.parent = y;
                y.color = node.color;
            }
            if (originalColor == Color.BLACK) fixDelete(x, node.parent);
        }

        private void fixDelete(Node x, Node parent) {
            while ((x != root) && (x == null || x.color == Color.BLACK)) {
                if (x == parent.left) {
                    Node w = parent.right;
                    if (w.color == Color.RED) {
                        w.color = Color.BLACK;
                        parent.color = Color.RED;
                        rotateLeft(parent);
                        w = parent.right;
                    }
                    if ((w.left == null || w.left.color == Color.BLACK) &&
                        (w.right == null || w.right.color == Color.BLACK)) {
                        w.color = Color.RED;
                        x = parent;
                        parent = x.parent;
                    } else {
                        if (w.right == null || w.right.color == Color.BLACK) {
                            if (w.left != null) w.left.color = Color.BLACK;
                            w.color = Color.RED;
                            rotateRight(w);
                            w = parent.right;
                        }
                        w.color = parent.color;
                        parent.color = Color.BLACK;
                        if (w.right != null) w.right.color = Color.BLACK;
                        rotateLeft(parent);
                        x = root;
                    }
                } else {
                    Node w = parent.left;
                    if (w.color == Color.RED) {
                        w.color = Color.BLACK;
                        parent.color = Color.RED;
                        rotateRight(parent);
                        w = parent.left;
                    }
                    if ((w.left == null || w.left.color == Color.BLACK) &&
                        (w.right == null || w.right.color == Color.BLACK)) {
                        w.color = Color.RED;
                        x = parent;
                        parent = x.parent;
                    } else {
                        if (w.left == null || w.left.color == Color.BLACK) {
                            if (w.right != null) w.right.color = Color.BLACK;
                            w.color = Color.RED;
                            rotateLeft(w);
                            w = parent.left;
                        }
                        w.color = parent.color;
                        parent.color = Color.BLACK;
                        if (w.left != null) w.left.color = Color.BLACK;
                        rotateRight(parent);
                        x = root;
                    }
                }
            }
            if (x != null) x.color = Color.BLACK;
        }

        private void transplant(Node u, Node v) {
            if (u.parent == null) root = v;
            else if (u == u.parent.left) u.parent.left = v;
            else u.parent.right = v;
            if (v != null) v.parent = u.parent;
        }

        private Node minimum(Node node) {
            while (node.left != null) node = node.left;
            return node;
        }

        private Node search(Node node, int val) {
            while (node != null && node.val != val) {
                node = (val < node.val) ? node.left : node.right;
            }
            return node;
        }

        private void rotateLeft(Node x) {
            Node y = x.right;
            x.right = y.left;
            if (y.left != null) y.left.parent = x;
            y.parent = x.parent;
            if (x.parent == null) root = y;
            else if (x == x.parent.left) x.parent.left = y;
            else x.parent.right = y;
            y.left = x;
            x.parent = y;
        }

        private void rotateRight(Node x) {
            Node y = x.left;
            x.left = y.right;
            if (y.right != null) y.right.parent = x;
            y.parent = x.parent;
            if (x.parent == null) root = y;
            else if (x == x.parent.left) x.parent.left = y;
            else x.parent.right = y;
            y.right = x;
            x.parent = y;
        }
    }
}
