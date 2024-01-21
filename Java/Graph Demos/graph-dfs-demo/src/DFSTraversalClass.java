import java.util.List;

public class DFSTraversalClass {

    public static void dfsTraversal(List<Edge>[] graphs, int curr, boolean[] visited) {

        System.out.print(curr+" ");

        visited[curr] = true;

        for (int i = 0; i < graphs[curr].size(); i++) {
            Edge edge = graphs[curr].get(i);
            if (!visited[edge.getDest()]) {
                dfsTraversal(graphs, edge.getDest(), visited);
            }
        }
    }
}
