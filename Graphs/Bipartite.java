package Graphs;

import java.util.*;

public class Bipartite {
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
        graph[0].add(new Edge(0,5,1));
        graph[0].add(new Edge(0,1,1));
        
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,4,1));

        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,7,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));
        graph[5].add(new Edge(5,0,1));

        graph[6].add(new Edge(6,5,1));

        graph[7].add(new Edge(7,4,1));

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

    public static boolean isBiparite(ArrayList<Edge> graph[]) {
        boolean vist[] = new boolean[graph.length];
        char color[] = new char[graph.length];
        Arrays.fill(color, 'w');
        for(int i=0; i<graph.length; i++) {
            if(!vist[i]) {
                color[i] = 'Y';
                if(!isBipariteUtil(graph,i,vist,color,color[i])) {
                   return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipariteUtil(ArrayList<Edge> graph[], int curr, boolean vist[], char color[],char currColor) {
        vist[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(e.dest!=curr && color[e.dest] == color[curr]) return false;

            color[e.dest] = currColor=='Y'?'O':'Y';  
            if(!vist[e.dest]) {
               if(!isBipariteUtil(graph, e.dest, vist, color, color[e.dest])) return false;   
            }                                 
        }
        return true;
    }
    public static void main(String args[]) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[8];
        createGraph(graph);
        printGraph(graph);
        System.out.println(isBiparite(graph));
    } 
}
