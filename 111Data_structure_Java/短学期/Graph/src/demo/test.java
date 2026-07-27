package demo;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {


        //获取有几个顶点，创建图
        int vertex ;
        System.out.println("请输入有几个顶点");
        Scanner scanner1 = new Scanner(System.in);
        vertex = scanner1.nextInt();
        Graph graph = new Graph(vertex);

        //添加边
        System.out.println("请以类似“1,5”的形式输入边，以绘制图");
        Scanner scanner2 = new Scanner(System.in);

        while (true) {
            String line = scanner2.nextLine();
            String[] input = line.split(",");
            if(input.length != 2) {
                break;
            }
            graph.addEdge(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }



        int start;

        Dfs dfs = new Dfs(graph);

        System.out.println("请输入开始顶点");
        Scanner scanner3 = new Scanner(System.in);
        start = scanner3.nextInt();
        System.out.printf("深度优先(从顶点 %d 开始): ",start);
        dfs.DFSTraverse(start);

    }

}
