import java.io.*;
import java.util.*;

public class Main {

    static int V;
    static int[][] capacity;
    static List<Integer>[] graph;

    static int bfs(int source, int sink, int[] parent) {
        Arrays.fill(parent, -1);
        parent[source] = source;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph[u]) {
                if (parent[v] == -1 && capacity[u][v] > 0) {
                    parent[v] = u;

                    if (v == sink) {
                        // Find bottleneck capacity
                        int flow = Integer.MAX_VALUE;
                        int cur = sink;

                        while (cur != source) {
                            int prev = parent[cur];
                            flow = Math.min(flow, capacity[prev][cur]);
                            cur = prev;
                        }

                        return flow;
                    }

                    queue.offer(v);
                }
            }
        }

        return 0; // No augmenting path
    }

    static long fordFulkerson(int source, int sink) {
        long maxFlow = 0;
        int[] parent = new int[V];

        int pathFlow;

        while ((pathFlow = bfs(source, sink, parent)) > 0) {
            maxFlow += pathFlow;

            int cur = sink;

            // Update residual capacities
            while (cur != source) {
                int prev = parent[cur];

                capacity[prev][cur] -= pathFlow;
                capacity[cur][prev] += pathFlow;

                // Add reverse edge if it wasn't already present
                if (!graph[cur].contains(prev)) {
                    graph[cur].add(prev);
                }

                cur = prev;
            }
        }

        return maxFlow;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        capacity = new int[V][V];

        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cap = Integer.parseInt(st.nextToken());

            capacity[u][v] += cap;

            graph[u].add(v);
            graph[v].add(u); // Reverse edge for residual graph
        }

        System.out.println(fordFulkerson(0, V - 1));
    }
}
