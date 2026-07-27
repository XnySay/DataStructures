package demo;

public class Graph {



    //以邻接矩阵为存储结构的图进行深度优先遍历的实现

    //使用二维数组存储邻接矩阵
    int[][] adjacencyMatrix;
    int numVertex;

    public Graph(int numVertex) {
        this.numVertex = numVertex;
        adjacencyMatrix = new int[numVertex][numVertex];
    }

    public void addEdge(int origin, int destination) {
        adjacencyMatrix[origin][destination] = 1;
        adjacencyMatrix[destination][origin] = 1;
    }

    public int get(int i) {
        return i;
    }

    public int next(int i, int j) {
        for (int k = j + 1; k < numVertex; k++) {
            if (adjacencyMatrix[i][k] == 1) {
                return k;
            }
        }
        return -1;
    }

    public int getNumVertex() {
        return numVertex;
    }

}
