import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversalClass {
    static void bfsTraversal(List<Edge>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        // consider and push the first vertex
        queue.add(0);

        while (!queue.isEmpty()) {
            Integer curr = queue.remove();

            if (!visited[curr]) {
                // print that element
                System.out.print(curr + " ");
                // make true in visited array
                visited[curr] = true;
                // push the all next destination vertex for current vertex
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge edge = graph[curr].get(i);
                    queue.add(edge.getDest());
                }
            }
        }
    }
}
