package Huffman;

import java.util.*;

public class HuffmanTree {

    Node root;

    public HuffmanTree(List<Node> nodes) {

        //优先队列，通过比较器compare判断两个结点的权值
        PriorityQueue<Node> pq = new PriorityQueue<>(nodes.size(), new Comparator<>() {
            public int compare(Node n1, Node n2) {
                return Double.compare(n1.weight, n2.weight);
            }
        });

        //对nodes表中的每一个Node进行入优先队列操作
        for (Node node : nodes) {
            pq.offer(node);
        }


        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left.weight + right.weight, left, right);
            pq.offer(parent);
        }

        root = pq.poll();
    }



    //调用buildCodeTableHelper创建表，保存每个叶子节点的哈弗曼编码
    public Map<String, String> buildCodeTable() {
        Map<String, String> codeTable = new HashMap<>();
        buildCodeTableHelper(root, "", codeTable);
        return codeTable;
    }

    private void buildCodeTableHelper(Node node, String code, Map<String, String> codeTable) {
        if (node == null) {
            return;
        }

        if (node.isLeaf()) {
            codeTable.put(node.ch, code);
        } else {
            buildCodeTableHelper(node.left, code + "0", codeTable);
            buildCodeTableHelper(node.right, code + "1", codeTable);
        }
    }

}
