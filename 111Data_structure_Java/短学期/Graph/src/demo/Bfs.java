package demo;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class GraphBFS {

    //顶点
    int vertices;

    //把边按照邻接表存储
    LinkedList<Integer>[] adjacencyList;


    public GraphBFS(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int origin, int destination) {
        adjacencyList[origin].add(destination);
        adjacencyList[destination].add(origin);
    }

    public int getNumVertex() {
        return vertices;
    }

    public int get(int i) {
        return i;
    }



}


public class Bfs {

    GraphBFS graphBFS;

    public Bfs(GraphBFS graphBFS) {
        this.graphBFS = graphBFS;
    }

    public void BFSTraverse(int start) {
        boolean[] visited = new boolean[graphBFS.getNumVertex()];
        int i = start;

        if(i<0 || i>=graphBFS.getNumVertex()) {
            return;
        }

        do {
            if (!visited[i]) {
                System.out.print("{");
                BFS(i, visited);
                System.out.print("}");
            }
            i = (i + 1) % graphBFS.getNumVertex();
        } while (i != start);
        System.out.println();
    }

    public void BFS(int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(graphBFS.get(v) + " ");
            for (int neighbor : graphBFS.adjacencyList[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

class testBFS{

    public static void main(String[] args) {


        //获取有几个顶点，创建图
        int vertex ;
        System.out.println("请输入有几个顶点");
        Scanner scanner1 = new Scanner(System.in);
        vertex = scanner1.nextInt();
        GraphBFS graphBFS = new GraphBFS(vertex);

        //添加边
        System.out.println("请以类似“1,5”的形式输入边，以绘制图");
        Scanner scanner2 = new Scanner(System.in);

        while (true) {
            String line = scanner2.nextLine();
            String[] input = line.split(",");
            if(input.length != 2) {
                break;
            }
            graphBFS.addEdge(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }





        Bfs bfs = new Bfs(graphBFS);

        System.out.println("请输入开始顶点");
        Scanner scanner3 = new Scanner(System.in);
        int start = scanner3.nextInt();
        System.out.printf("广度优先(从顶点 %d 开始): ",start);
        bfs.BFSTraverse(start);

    }

}






















