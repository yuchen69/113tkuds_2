public class AVLNode {
    int data;
    AVLNode left, right;
    int height;

    public AVLNode(int data) {
        this.data = data;
        this.height = 1;
    }

    public int getBalance() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        return leftHeight - rightHeight;
    }

    public void updateHeight() {
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        this.height = Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        AVLNode node = new AVLNode(10);
        node.left = new AVLNode(5);
        node.right = new AVLNode(15);
        node.updateHeight();
        System.out.println("Root value: " + node.data);
        System.out.println("Root height: " + node.height);
        System.out.println("Root balance factor: " + node.getBalance());
    }
}
