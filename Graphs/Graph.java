import java.util.*;

public class Graph {
    static class Edge{
        int src,dest,weight;

        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }
    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                bfsUtil(graph, visited, i);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] visited, int src){
        Queue<Integer> q = new LinkedList<>();
        q.add(src); //source vertex
        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visited[curr]){
                visited[curr] = true;
                System.out.print(curr + " ");
                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                dfsUtil(graph, i, visited);
            }
        }
    }
    
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean visited[]){
        System.out.println(curr);
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int curr, int dest, boolean visited[]){
        if(curr == dest){
            return true;
        }
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        //we will be using adjacency list to represent the graph
        //adjacency list will be in form of array of arraylists of type edge
        
        //example graph
        // 0----1
        // |    |
        // 2----3
        //  \  /
        //   4


        int V = 5; //number of vertices
        ArrayList<Edge>[] adj = new ArrayList[V]; //currently all values are null

        //initializing the array of arraylists
        for(int i=0;i<V;i++){
            adj[i] = new ArrayList<>();
        }

        //adding edges to the graph
        adj[0].add(new Edge(0,1,1));
        adj[0].add(new Edge(0,2,1));
        adj[1].add(new Edge(1,0,1));
        adj[1].add(new Edge(1,3,1));
        adj[2].add(new Edge(2,0,1));
        adj[2].add(new Edge(2,3,1));
        adj[2].add(new Edge(2,4,1));
        adj[3].add(new Edge(3,1,1));
        adj[3].add(new Edge(3,2,1));
        adj[3].add(new Edge(3,4,1));
        adj[4].add(new Edge(4,2,1));
        adj[4].add(new Edge(4,3,1));

        // //getting the information for vertex 2 neighbours
        // for(int i = 0; i < adj[2].size(); i++){
        //     Edge e = adj[2].get(i);
        //     System.out.println("src: " + e.src + " dest: " + e.dest + " weight: " + e.weight);
        // }

        bfs(adj);
        dfs(adj, 0, new boolean[5]);
        System.out.println(hasPath(adj, 0, 4, new boolean[5]));
    }
}
