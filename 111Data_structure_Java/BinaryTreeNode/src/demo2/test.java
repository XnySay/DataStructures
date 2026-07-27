package demo2;

public class test {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        SeqBinaryTree tree = new SeqBinaryTree(array);
        BinaryTreeNode root = tree.buildBinaryTree();
        System.out.print("Preorder Traversal: ");
        tree.preorderTraversal(root);
        System.out.print("\nInorder Traversal: ");
        tree.inorderTraversal(root);
        System.out.print("\nPostorder Traversal: ");
        tree.postorderTraversal(root);
    }
}
