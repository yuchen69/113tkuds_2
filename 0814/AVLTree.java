public class AVLTree {
    AVLNode root;

    private int height(AVLNode node) {
        return (node != null) ? node.height : 0;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private AVLNode insert(AVLNode node, int key) {
        if (node == null) return new AVLNode(key);

        if (key < node.data) node.left = insert(node.left, key);
        else if (key > node.data) node.right = insert(node.right, key);
        else return node;

        node.updateHeight();
        int balance = node.getBalance();

        if (balance > 1 && key < node.left.data) return AVLRotations.rightRotate(node);
        if (balance < -1 && key > node.right.data) return AVLRotations.leftRotate(node);
        if (balance > 1 && key > node.left.data) {
            node.left = AVLRotations.leftRotate(node.left);
            return AVLRotations.rightRotate(node);
        }
        if (balance < -1 && key < node.right.data) {
            node.right = AVLRotations.rightRotate(node.right);
            return AVLRotations.leftRotate(node);
        }

        return node;
    }

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(AVLNode node, int key) {
        if (node == null) return false;
        if (key == node.data) return true;
        else if (key < node.data) return search(node.left, key);
        else return search(node.right, key);
    }
}
