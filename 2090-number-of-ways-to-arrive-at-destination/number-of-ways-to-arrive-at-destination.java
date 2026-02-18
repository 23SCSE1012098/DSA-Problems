// class Solution {
//     public class Pair{
//         int node ;
//         int distance;
//         Pair(int node, int distance){
//             this.node=node;
//             this.distance=distance;
//         }
//     }
//     public int countPaths(int n, int[][] roads) {
//         ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
//         for(int[] road:roads){
//             int u=road[0];
//             int v=road[1];
//             int time=road[2];
//             adj.get(u.add(new Pair(v,time)));
//             adj.get(v.add(new Pair(u,time)));
//         }
//         int[] dist = new int [n];
//         int ways[] =new int [n];
//         Arrays.fill(dist,-1);
//         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.distance-b.distance);
//         pq.add(new Pair(0,0));
//         dist[0]=0;
//         ways[0]=1;
//         while(!pq.isEmpty()){
//             Pair curr = pq.remove();
//             int d= curr.distance;
//             int u =curr.node;
//             if(d>dist[u]) continue;
//             for(Pair neig :adj.get(u)){
//                 int v = neig.node;
//                 int weight = neig.distance;
                
//                 if(dist[v]>d+weight){
//                     dist[v]=d+weight;
//                     ways[v]=ways[u];
//                     pq.offer(new Pair(v,dist[v]));
//                 }
//                 else if(dist[v]==d+weight){
//                     ways[v]=(ways[v]+way[u])%mod;
//                 }
//             }

//         }
//         return ways[n-1];



        
//     }
// }



import java.util.*;

class Solution {
    public class Pair {
        int node;
        long distance; // Use long for distance
        Pair(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int countPaths(int n, int[][] roads) {
        // Initialize the adjacency list correctly
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        // Use long for distances to prevent potential overflow
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE); // Initialize with infinity

        // Priority queue ordered by distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));

        pq.add(new Pair(0, 0));
        dist[0] = 0;
        ways[0] = 1;

        int mod = 1000000007; // Define the modulo value

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            long d = curr.distance;
            int u = curr.node;

            // Optimization: if current distance is greater than the best known, skip
            if (d > dist[u]) continue;

            // Iterate over neighbors
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                // Case 1: Found a shorter path to v
                if (dist[v] > d + weight) {
                    dist[v] = d + weight;
                    ways[v] = ways[u];
                    pq.offer(new Pair(v, dist[v]));
                } 
                // Case 2: Found another path with the same shortest length
                else if (dist[v] == d + weight) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }
        // Return the number of ways to reach the last node
        return (int) ways[n - 1];
    }
}
