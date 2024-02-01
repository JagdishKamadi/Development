package with_edge;

import java.util.ArrayList;
import java.util.List;

public class GraphWithEdgeTest {
    public static void main(String[] args) {
        int vertex = 4;
        ArrayList<Edge>[] graph = new ArrayList[vertex];

        createGraph(graph);

        // how to travel the particular vertex all destinations
        // consider the example of vertex 2
        for (int i = 0; i < graph[2].size(); i++) {
            System.out.print(graph[2].get(i).getDest() + " ");
        }

        // consider the example of vertex 1
        System.out.println();
        for (int i = 0; i < graph[1].size(); i++) {
            System.out.print(graph[1].get(i).getDest() + " ");
        }
    }

    private static void createGraph(List<Edge>[] graph) {

        // firstly fill the null with empty
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // here we will set the edge for each vertex
        // set the vertex 0 source and destination
        graph[0].add(new Edge(0, 2));

        // set the vertex 1 source and destination
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        // set the vertex 2 source and destination
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        // set the vertex 3 source and destination
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }
}
