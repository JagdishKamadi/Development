package with_edge_weight;

import java.util.ArrayList;
import java.util.List;

public class GraphWithEdgeAndWeightTest {
    public static void main(String[] args) {

        int vertex = 4;
        List<Edge>[] graph = new ArrayList[vertex];
        createGraph(graph);

        // how to travel the particular vertex all destinations and weights
        // consider the example of vertex 2
        System.out.printf("Destination and weight of %d\n", graph[2].get(0).getSrc());
        for (int i = 0; i < graph[2].size(); i++) {
            System.out.printf("dest %d weight %d\n", graph[2].get(i).getDest(), graph[2].get(i).getWeight());
        }

        // consider the example of vertex 1
        System.out.printf("\nDestination and weight of %d\n", graph[1].get(0).getSrc());
        for (int i = 0; i < graph[1].size(); i++) {
            System.out.printf("dest %d weight %d\n", graph[2].get(i).getDest(), graph[2].get(i).getWeight());
        }
    }

    private static void createGraph(List<Edge>[] graph) {

        // firstly fill the null with empty
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // here we will set the edge for each vertex
        // set the vertex 0 source and destination
        graph[0].add(new Edge(0, 2, 3));

        // set the vertex 1 source and destination
        graph[1].add(new Edge(1, 2, 4));
        graph[1].add(new Edge(1, 3, 5));

        // set the vertex 2 source and destination
        graph[2].add(new Edge(2, 0, 3));
        graph[2].add(new Edge(2, 1, 4));
        graph[2].add(new Edge(2, 3, -1));

        // set the vertex 3 source and destination
        graph[3].add(new Edge(3, 1, 5));
        graph[3].add(new Edge(3, 2, -1));
    }
}
