package demo;

import java.util.Arrays;

class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    public BinaryTreeNode root;
    public BinaryTree() {
        this.root = null;
    }

    public BinaryTreeNode buildBinaryTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];  // 根节点的值
        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }

        // 构造根节点
        BinaryTreeNode root = new BinaryTreeNode(rootVal);

        // 递归构造左子树和右子树
        root.left = buildBinaryTree(Arrays.copyOfRange(preorder, 1, idx+1), Arrays.copyOfRange(inorder, 0, idx));
        root.right = buildBinaryTree(Arrays.copyOfRange(preorder, idx+1, preorder.length), Arrays.copyOfRange(inorder, idx+1, inorder.length));

        return root;
    }

//    前序遍历：访问根节点，然后递归遍历左子树和右子树。
    public void preorderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }



//    中序遍历：递归遍历左子树，访问根节点，然后递归遍历右子树。

    public void inorderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.value + " ");
        inorderTraversal(root.right);
    }

//    后序遍历：递归遍历左子树和右子树，然后访问根节点。
    public void postorderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.value + " ");
    }
}





















