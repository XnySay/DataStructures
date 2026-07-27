package Demo;
import java.util.*;


public class BuildBinarySearchTree {

    TreeNode root;
    // 插入新节点
    void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        TreeNode node = root;
        while (true) {
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
    }

    // 递归遍历二叉排序树，按从大到小的顺序输出节点的值,中序，右根左
    void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.right);
        System.out.print(node.val + " ");
        traverse(node.left);
    }
}


class test{

    public static void main(String[] args) {
        // 读入数据并插入到二叉排序树中
        Scanner scanner = new Scanner(System.in);
        BuildBinarySearchTree buildBinarySearchTree = new BuildBinarySearchTree();
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            buildBinarySearchTree.insert(val);
        }
        // 遍历二叉排序树并输出结果
        buildBinarySearchTree.traverse(buildBinarySearchTree.root);
        System.out.println();
    }
}