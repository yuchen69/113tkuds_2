import java.util.*;

public class RBTreeIteratorExercise {
    static class Node {
        int val;
        Node left, right;
        Node(int val) { this.val = val; }
    }

    static class RBIterator {
        Stack<Node> stack = new Stack<>();

        RBIterator(Node root) {
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        boolean hasNext() {
            return !stack.isEmpty();
        }

        int next() {
            Node node = stack.pop();
            pushLeft(node.right);
            return node.val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        RBIterator it = new RBIterator(root);
        while (it.hasNext()) System.out.println(it.next());
    }
}
