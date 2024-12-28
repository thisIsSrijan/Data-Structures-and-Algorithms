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
                dfs(graph);
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

    //cycle detection in undirected graph
    public static boolean isCyclic(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                if(isCyclicUtil(graph, visited, i, -1)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent){
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            
            if(!visited[e.dest]){ //case3 if the neighbour is not visited and not parent
                if(isCyclicUtil(graph, visited, e.dest, curr))
                    return true;
            }
            else if(visited[e.dest] && e.dest != parent)
                return true;
        }

        return false;
    }

    //Bipartite Graph
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i=0; i < graph.length; i++){
            if(!isBipartiteUtil(graph, i, color))
                return false;
        }

        return true;
    }

    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int curr, int color[]){
        Queue<Integer> q = new java.util.LinkedList<>();
        q.add(curr);

        while(!q.isEmpty()){
            int parent = q.remove();

            if(color[parent] == -1)
                color[parent] = 0;

            for(int i = 0; i < graph[parent].size(); i++){
                Edge e = graph[parent].get(i);

                //case1: neighbour is uncoloured, assign different colour
                if(color[e.dest] == -1){
                    if(color[parent] == 0)
                        color[e.dest] = 1;
                    else
                        color[e.dest] = 0;

                    q.add(e.dest);
                }else{
                    if(color[e.dest] == color[parent])
                        return false;
                }
            }
        }

        return true;
    }

    //cycle detection for acyclic graphs
    public static boolean isCyclic_directed(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i = 0; i < graph.length; i++){
            if(!visited[i])
                if(isCyclic_directedUtil(graph, i, visited, stack))
                    return true;
        }

        return false;
    }

    private static boolean isCyclic_directedUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], boolean stack[]){
        visited[curr] = true;
        stack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(stack[e.dest])
                return true;
            if(!visited[e.dest] && isCyclic_directedUtil(graph, e.dest, visited, stack))
                return true;
        }

        stack[curr] = false;
        return false;
    }

    //topological sorting : for DAG
    public static void topSort(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < graph.length; i++){
            if(!visited[i])
                topSortUtil(graph, i, visited, stack);
        }

        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }

    private static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean visited[], Stack<Integer> stack){
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!visited[e.dest])
                topSortUtil(graph, e.dest, visited, stack);
        }

        stack.push(curr);
    }

    //topological sort using BFS: Kahn's algo
    public static void topoSort_bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = findIndegree(graph);

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");

            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(--indegree[e.dest] == 0)
                    q.add(e.dest);
            }
        }
    }

    private static int[] findIndegree(ArrayList<Edge>[] graph){
        int indegree[] = new int[graph.length];

        for(int i = 0; i < graph.length; i++){
            for(int j = 0 ; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }

        return indegree;
    }

    //Dijkstra's algo : fails for negative weight edges 
    static class Pair implements Comparable<Pair>{
        int node;
        int path; //distance of node from src

        public Pair(int n, int p){
            this.node = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p){
            return this.path - p.path; 
        }
    }

    public static void getShortestPath(int src, ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        int dist[] = new int[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        //initializing all dist = infinity accept the src to src
        for(int i = 0; i < graph.length; i++){
            if(src != i)
                dist[i] = Integer.MAX_VALUE;
        }

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node] = true;
                //neighbours
                for(int i=0; i<graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
    }

    //BellmanFord algorithm: O(V*E)
    public static void bellman_ford(ArrayList<Edge>[] graph, int src){
        int V = graph.length;
        int dist[] = new int[V];

        for(int i = 0; i < dist.length; i++){
            if(i!= src)
                dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < V-1; i++){ //O(V)
            for(int j = 0; j < graph.length; j++){ //O(E)
                for(int k = 0; k < graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for(int i = 0; i < dist.length; i++)
            System.out.print(dist[i]+" ");
    }

    // MST: Prim's algorithm
    static class MSTPair implements Comparable<MSTPair>{
        int vertex;
        int cost;

        public MSTPair(int v, int c){
            this.vertex = v;
            this.cost = c;
        }

        @Override
        public int compareTo(MSTPair p){
            return this.cost - p.cost;
        }

    }
    public static void find_mst(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        ArrayList<MSTPair> mst = new ArrayList<>(); //for storing the mst pairs and printing the edges
        PriorityQueue<MSTPair> pq = new PriorityQueue<>();
        pq.add(new MSTPair(0, 0)); //add 0th vertex intially

        while(!pq.isEmpty()){
            MSTPair curr = pq.poll();
            if(!visited[curr.vertex]){
                visited[curr.vertex] = true;
                mst.add(curr);
                for(int i = 0; i < graph[curr.vertex].size(); i++){
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new MSTPair(e.dest, e.weight));
                }
            }
        }

        int min_cost = 0;
        for(MSTPair p: mst){
            min_cost += p.cost;
        }

        System.out.println("minimum cost tree: "+min_cost);
    }
    

    public static void main(String[] args) {
        int V = 3; // Number of vertices

        // Cyclic Graph
        ArrayList<Edge>[] cyclicGraph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            cyclicGraph[i] = new ArrayList<>();
        }

        cyclicGraph[0].add(new Edge(0, 1, 1));
        cyclicGraph[0].add(new Edge(1, 2, 1));
        cyclicGraph[1].add(new Edge(2, 0, 1));

        System.out.println("Topological sort: ");
        topSort(cyclicGraph);
        System.out.println();
        System.out.println("Topological sort using BFS: ");
        topoSort_bfs(cyclicGraph);
    }
}