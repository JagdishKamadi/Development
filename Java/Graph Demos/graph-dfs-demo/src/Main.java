import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int vertex = 5;

        List<Edge>[] graph = new ArrayList[vertex];
        createGraph(graph);
        boolean[] visited = new boolean[vertex];
        DFSTraversalClass.dfsTraversal(graph,0,visited);
    }


    /* Constructing below graph

           1 ------ 3
          /|        |
         0 |        |
          \|        |
           2 ------ 4
     */
    private static void createGraph(List<Edge>[] graph) {

        // firstly fill the null with empty

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // here we will set the edge for each vertex
        // set the vertex 0 source and destination
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // set the vertex 1 source and destination
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        // set the vertex 2 source and destination
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));

        // set the vertex 3 source and destination
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        // set the vertex 4 source and destination
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

}