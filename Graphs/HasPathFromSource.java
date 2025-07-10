package Graphs;

import java.util.ArrayList;

public class HasPathFromSource {
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

    public static boolean hasPath(ArrayList<Edge> graph[], int frm, int too) {

        if(frm == too) return true;

        for(int i=0; i<graph[frm].size(); i++) {
            Edge e = graph[frm].get(i);
            
            if(hasPath(graph,e.dest,too)) return true;
        }
       return false;
    }

    public static void main(String args[]) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[6];
        createGraph(graph);
        printGraph(graph);
        int from = 5;
        int too = 4;
        System.out.println(hasPath(graph,from,too));
    }
}
