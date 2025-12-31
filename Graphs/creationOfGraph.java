//Storing a graph: Adjacancy List, Adjacancy Matrix, Edge List, Implicit 2D matrix;

import java.util.*;

public class creationOfGraph {
    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest){
            this(src, dest, 1);
        }

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 2, 2));

        for(int i = 0; i<V; i++){
            System.out.print(i + " -> ");
            for(Edge e : graph[i]){
                System.out.print(e.dest + ", ");
            }
            System.out.println();
        }

        return;
    }
}
