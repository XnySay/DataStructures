package Huffman;

import java.util.*;

public class test {

    public static void main(String[] args) {

        //拿到数据
        System.out.println("请输入类似（A，0.9）的数据");
        Scanner scanner = new Scanner(System.in);


        List<Node> nodes = new ArrayList<>();

        //数据处理
        while (true) {
            String line = scanner.nextLine();
            String input = line.replaceAll("[()]", "");
            String[] a = input.split(",");
            if (a.length != 2) {
                break;
            }

            //处理数据，加入列表
            String ch = a[0];
            double weight = Double.parseDouble(a[1]);
            Node node = new Node(ch, weight);
            nodes.add(node);
        }

        //新建树，新建表
        HuffmanTree tree = new HuffmanTree(nodes);
        Map<String, String> codeTable = tree.buildCodeTable();
        //遍历 codeTable 中的所有键值对，将每个键值对赋值给变量 entry，并依次输出键值对
        for (Map.Entry<String, String> entry : codeTable.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
