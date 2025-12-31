import java.util.*;

public class BFS {
    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
            this.wt = 1;
        }

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, Queue<Integer> q, boolean[] visited){
        if(q.isEmpty()){
            return;
        }

        int pt = q.remove();
        if(!visited[pt]){
            visited[pt] = true;
            
            for(Edge e : graph[pt]){
                q.add(e.dest);
            }

            System.out.print(pt + " ");
        }
        
        bfs(graph, q, visited);
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V]; 
        
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(5, 6));

        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        bfs(graph, q, visited);

        return;
    }
}
