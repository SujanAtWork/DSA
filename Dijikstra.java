import java.util.*;

public class Dijikstra{

    class Edge{
        int target, weight;
        Edge(target, weight){
            this.target = target;
            this.weight = weight;
        }

        void dijikstra(int source, Map<Integer, List<Edge>> graph, int n){
            int dis = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dis[source] = 0;

            boolean visited[] = new boolean[10];
            Arrays.fill(visited, true);

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[]{source, 0});

            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                int node = curr[0] , dis = curr[1];

                if(d> dis[node]) continue;

                for(Edge E : graph.getOrDefault(node, new ArrayList<>())){
                    if (dist[node] + e.weight < dist[e.target]) {
                        dist[e.target] = dist[node] + e.weight;
                        spq.add(new int[]{e.target, dist[e.target]});
            }
        }
                }
            }

        }
    }
    
}
