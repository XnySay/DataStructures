package demo;


public class Dfs {
    Graph graph;

    public Dfs(Graph graph) {
        this.graph = graph;
    }


    public void DFSTraverse(int i) {

        boolean[] visited = new boolean[graph.getNumVertex()];

        if (i < 0 || i >= graph.getNumVertex()) {
            return;
        }

        DFS(i, visited);

        for (int j = 0; j < graph.getNumVertex(); j++) {
            if (!visited[j]) {
                DFS(j, visited);
            }
        }
        System.out.println();

    }
    public void DFS(int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(graph.get(i));
        for (int j = graph.next(i, -1); j != -1; j = graph.next(i, j)) {
            if (!visited[j]) {
                DFS(j, visited);
            }
        }
    }
}
