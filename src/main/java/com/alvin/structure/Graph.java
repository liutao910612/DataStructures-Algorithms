package com.alvin.structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 无向图
 * </p>
 *
 * @author alvinl
 * @date 12/10/19 11:24
 **/
public class Graph {
    private int v;    //顶点的个数
    private LinkedList<Integer> adj[];    //邻接表
    boolean found = false;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }

        //记录已经被访问的顶点
        boolean[] visited = new boolean[v];
        visited[s] = true;

        //用来存储已经被访问、但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * <p>
     * 递归打印s -> t的路径
     * </p>
     *
     * @param prev
     * @param s
     * @param t
     * @return void
     * @author alvinl
     * @date 12/10/19 13:48
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }


    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s,t,visited,prev);

        print(prev, s, t);

    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }

        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }

        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}
