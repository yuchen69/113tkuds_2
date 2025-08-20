public class RBInsertFixupExercise {
    enum Color { RED, BLACK }

    static class Node {
        int val;
        Color color;
        Node left, right, parent;
        Node(int val) { this.val = val; this.color = Color.RED; }
    }

    static class RBTree {
        Node root;

        void insert(int val) {
            Node newNode = new Node(val);
            root = bstInsert(root, newNode);
            insertFixup(newNode);
        }

        private Node bstInsert(Node root, Node node) {
            if (root == null) return node;
            if (node.val < root.val) {
                root.left = bstInsert(root.left, node);
                root.left.parent = root;
            } else {
                root.right = bstInsert(root.right, node);
                root.right.parent = root;
            }
            return root;
        }

        private void insertFixup(Node node) {
            while (node.parent != null && node.parent.color == Color.RED) {
                Node grand = node.parent.parent;
                if (grand == null) break;
                if (node.parent == grand.left) {
                    Node uncle = grand.right;
                    if (uncle != null && uncle.color == Color.RED) {
                        node.parent.color = Color.BLACK;
                        uncle.color = Color.BLACK;
                        grand.color = Color.RED;
                        node = grand;
                    } else {
                        if (node == node.parent.right) {
                            node = node.parent;
                            rotateLeft(node);
                        }
                        node.parent.color = Color.BLACK;
                        grand.color = Color.RED;
                        rotateRight(grand);
                    }
                } else {
                    Node uncle = grand.left;
                    if (uncle != null && uncle.color == Color.RED) {
                        node.parent.color = Color.BLACK;
                        uncle.color = Color.BLACK;
                        grand.color = Color.RED;
                        node = grand;
                    } else {
                        if (node == node.parent.left) {
                            node = node.parent;
                            rotateRight(node);
                        }
                        node.parent.color = Color.BLACK;
                        grand.color = Color.RED;
                        rotateLeft(grand);
                    }
                }
            }
            root.color = Color.BLACK;
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
