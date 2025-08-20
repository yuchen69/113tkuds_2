public class RBIntervalTreeExercise {
    enum Color { RED, BLACK }

    static class Interval {
        int low, high;
        Interval(int l, int h) { low = l; high = h; }
    }

    static class Node {
        Interval interval;
        int max;
        Color color;
        Node left, right, parent;
        Node(Interval i) { interval = i; max = i.high; color = Color.RED; }
    }

    static class IntervalTree {
        Node root;

        void insert(Interval i) {
            Node node = new Node(i);
            root = bstInsert(root, node);
            insertFixup(node);
            updateMaxUpwards(node);
        }

        Node bstInsert(Node root, Node node) {
            if (root == null) return node;
            if (node.interval.low < root.interval.low) {
                root.left = bstInsert(root.left, node);
                root.left.parent = root;
            } else {
                root.right = bstInsert(root.right, node);
                root.right.parent = root;
            }
            return root;
        }

        void insertFixup(Node node) {
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

        void updateMaxUpwards(Node node) {
            while (node != null) {
                node.max = node.interval.high;
                if (node.left != null) node.max = Math.max(node.max, node.left.max);
                if (node.right != null) node.max = Math.max(node.max, node.right.max);
                node = node.parent;
            }
        }

        void rotateLeft(Node x) {
            Node y = x.right;
            x.right = y.left;
            if (y.left != null) y.left.parent = x;
            y.parent = x.parent;
            if (x.parent == null) root = y;
            else if (x == x.parent.left) x.parent.left = y;
            else x.parent.right = y;
            y.left = x;
            x.parent = y;
            updateMaxUpwards(x);
        }

        void rotateRight(Node x) {
            Node y = x.left;
            x.left = y.right;
            if (y.right != null) y.right.parent = x;
            y.parent = x.parent;
            if (x.parent == null) root = y;
            else if (x == x.parent.left) x.parent.left = y;
            else x.parent.right = y;
            y.right = x;
            x.parent = y;
            updateMaxUpwards(x);
        }

        Node searchOverlap(Interval i) {
            Node node = root;
            while (node != null && !overlap(i, node.interval)) {
                if (node.left != null && node.left.max >= i.low) node = node.left;
                else node = node.right;
            }
            return node;
        }

        boolean overlap(Interval a, Interval b) {
            return a.low <= b.high && b.low <= a.high;
        }
    }
}
