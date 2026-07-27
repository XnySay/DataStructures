#include <stdio.h>
#include <stdbool.h>

#define MAX_VERTICES 100 // 假设图中最多有100个顶点

// 邻接矩阵的类型定义
typedef bool AdjMatrix[MAX_VERTICES][MAX_VERTICES];

// 路径数组和访问标记数组
int a[MAX_VERTICES]; // 存储路径
bool vis[MAX_VERTICES]; // 标记数组，记录节点是否被访问过

// 初始化图
void initGraph(AdjMatrix G, int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            G[i][j] = false; // 初始化所有边为不存在
        }
    }
}

// 添加边
void addEdge(AdjMatrix G, int start, int end) {
    G[start][end] = true;
}

// 深度优先搜索
void dfs(AdjMatrix G,int dep, int n) {
    vis[a[dep]] = true; // 标记当前节点为已访问
    printf("%d ", a[dep]); // 打印当前节点

    for(int i = 1; i <= n; ++i) {
        if(!vis[i] && G[a[dep]][i]) { // 如果节点未访问且存在边
            a[dep + 1] = i; // 将当前节点设置为i
            dfs(G,dep + 1, n); // 递归搜索
            a[dep + 1] = 0; // 回溯，恢复路径
        }
    }

    vis[a[dep]] = false; // 回溯，取消当前节点的访问标记
}

int main() {
    int n; // 顶点的数量
    printf("Enter the number of vertices: ");
    scanf("%d", &n);

    AdjMatrix G;
    initGraph(G, n);

    // 假设我们有一个图，顶点编号从1到n，边如下：
    // 1-2, 1-3, 2-4
    addEdge(G, 0, 1);
    addEdge(G, 0, 2);
    addEdge(G, 1, 3);
    addEdge(G, 2, 4);

    // 初始化访问标记数组
    for (int i = 0; i < n; i++) {
        vis[i] = false;
    }

    // 从顶点1开始深度优先搜索
    dfs(G,0, n);

    return 0;
}