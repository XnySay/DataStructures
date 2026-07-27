package demo;

public class test {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6};
        int[] inorder = {4, 2, 5, 1, 6, 3};

        BinaryTree tree = new BinaryTree();
        tree.root = tree.buildBinaryTree(preorder, inorder);

        System.out.print("Preorder traversal: ");
        tree.preorderTraversal(tree.root);
        System.out.println();

        System.out.print("Inorder traversal: ");
        tree.inorderTraversal(tree.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorderTraversal(tree.root);
        System.out.println();
    }
}
