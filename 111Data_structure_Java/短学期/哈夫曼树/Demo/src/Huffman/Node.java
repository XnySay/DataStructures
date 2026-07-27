package Huffman;

public class Node {

    String ch;
    double weight;
    Node left;
    Node right;


    //构造方法，字符+权值
    public Node(String ch, double weight) {
        this.ch = ch;
        this.weight = weight;
        this.left = null;
        this.right = null;
    }


    //构造方法，权值+左孩子右孩子
    public Node(double weight, Node left, Node right) {
        this.ch = "A";
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    //判断是不是叶子节点
    public boolean isLeaf() {
        return (left == null && right == null);
    }

}
