package demo2;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }
}

public class SeqBinaryTree {
    public Integer[] array;

    public SeqBinaryTree(Integer[] array) {
        this.array = array;
    }

    public BinaryTreeNode buildBinaryTree() {
        if (array == null || array.length == 0) {
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(array[0]);

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            BinaryTreeNode node = queue.poll();
            if (array[i] != null) {
                node.left = new BinaryTreeNode(array[i]);
                queue.offer(node.left);
            }
            i++;
            if (array[i] != null) {
                node.right = new BinaryTreeNode(array[i]);
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

    public void preorderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void inorderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.value + " ");
            node = node.right;
        }
    }

    public void postorderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            BinaryTreeNode node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            BinaryTreeNode node = stack2.pop();
            System.out.print(node.value + " ");
        }
    }

}
