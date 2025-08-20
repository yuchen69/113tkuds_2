public class AVLRotations {

    public static AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.updateHeight();
        x.updateHeight();

        return x;
    }

    public static AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.updateHeight();
        y.updateHeight();

        return y;
    }

    public static void main(String[] args) {
        AVLNode root = new AVLNode(30);
        root.left = new AVLNode(20);
        root.left.left = new AVLNode(10);

        System.out.println("Before Right Rotation: Root = " + root.data);
        root = rightRotate(root);
        System.out.println("After Right Rotation: Root = " + root.data);

        AVLNode root2 = new AVLNode(10);
        root2.right = new AVLNode(20);
        root2.right.right = new AVLNode(30);

        System.out.println("Before Left Rotation: Root = " + root2.data);
        root2 = leftRotate(root2);
        System.out.println("After Left Rotation: Root = " + root2.data);
    }
}
