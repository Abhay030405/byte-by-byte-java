package Graphs;

import java.util.*;
public class Implementation {

    static class Edge {
        int src;
        int dest;
        int weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,9,1));
        graph[0].add(new Edge(0,8,1));

        graph[1].add(new Edge(1,0,1)); 
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        
        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,4,1));

        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
        graph[6].add(new Edge(6,7,1));

        graph[7].add(new Edge(7,6,1));
        graph[7].add(new Edge(7,8,1));

        graph[8].add(new Edge(8,7,1));
        graph[8].add(new Edge(8,0,1));

        graph[9].add(new Edge(9,0,1));
        
       
    }
    public static void printGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
           System.out.print("Node " + i + " => ");
           for (Edge edge : graph[i]) {
                System.out.print(" (to: " + edge.dest + ", weight: " + edge.weight + ") ");
            }
            System.out.println(); // Newline for each node
        }
    }


    // Search operations in Graph 
    public static void bfs(ArrayList<Edge> graph[]) {
        boolean vist[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vist[i]) {
                bfsUtil(graph, vist,i);
            }
        }
        
    }
    public static void bfsUtil(ArrayList<Edge> graph[], boolean vist[], int st) {
        Queue<Integer> q = new LinkedList<>();
        // boolean vist[] = new boolean[graph.length];
        q.add(st);
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(vist[curr] != true) {
                vist[curr] = true;
                System.out.print(curr+" ");
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[]) {
        boolean vist[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vist[i]) {
                dfsUtil(graph, vist,i);
            }
        }
    }
    public static void dfsUtil(ArrayList<Edge> graph[], boolean vist[], int st) {
        vist[st] = true;
        System.out.print(st + " ");
        for(int i=0; i<graph[st].size(); i++) {
            Edge e = graph[st].get(i);
            if(!vist[e.dest]) {
               dfsUtil(graph, vist,e.dest); 
            }
        } 
    }

    public static void main(String args[]) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[14];
        createGraph(graph);
        printGraph(graph);
        System.out.print("BFS Traversal : ");
        bfs(graph);
        System.out.println();
        System.out.print("DFS Traversal : ");
        dfs(graph);
    }
}