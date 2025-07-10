package Graphs;

import java.util.*;

public class TopologicalSorting {
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
        graph[2].add(new Edge(2,3,1));
        
        graph[3].add(new Edge(3,1,1));

        graph[4].add(new Edge(4,0,1));
        graph[4].add(new Edge(4,1,1));

        graph[5].add(new Edge(5,0,1));
        graph[5].add(new Edge(5,2,1));

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

    public static void topoSortingDFS(ArrayList<Edge> graph[]) {
        boolean vist[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<graph.length; i++) {
            if(!vist[i]) {
                topoSortingDFSUitl(graph,i, vist, st);
            }
        }
        while(!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
    public static void topoSortingDFSUitl(ArrayList<Edge> graph[], int curr, boolean vist[], Stack<Integer> st) {
        vist[curr] = true;
        for(int i=0 ; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!vist[e.dest])  topoSortingDFSUitl(graph, e.dest, vist,st) ;

        }
        st.push(curr);
    }
    public static int[] calcIndegree(ArrayList<Edge> graph[]) {
        int inDegree[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }
        return inDegree;  
    }
    public static void topoSortingBFS(ArrayList<Edge> graph[]) {
        boolean vist[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(!vist[i]) {
                topoSortingBFSUtil(graph,calcIndegree(graph),vist,q);
            }
        }   
    }

    public static void topoSortingBFSUtil(ArrayList<Edge> graph[], int[] inDegree, boolean[] vist, Queue<Integer> q) {
        for(int i=0; i<inDegree.length; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(!vist[curr]) {
                vist[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                  Edge e = graph[curr].get(i);
                  inDegree[e.dest] --;
                }
               System.out.print(curr +" ");
            }
            inDegree[curr] = -1;
            for(int i=0; i<inDegree.length; i++) {
                if(inDegree[i] == 0) q.add(i);
            }
        }
    }

    public static void main(String args[]) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);
        printGraph(graph);
        System.out.print("Topological Sort Using DFS: ");
        topoSortingDFS(graph);
        System.out.println();
        System.out.print("Topological Sort Using BFS: ");
        topoSortingBFS(graph);
    }
}
