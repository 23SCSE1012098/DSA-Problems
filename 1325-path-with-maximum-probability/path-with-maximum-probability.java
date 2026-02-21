// class Solution {
//     public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//         ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
//         for(int i=0;i<n;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int [] x: adj){
//             int u=x[0];
//             int v=x[1];
//             int w=x[2];
//             adj.get(u).add(new int[]{v,w});
//             adj.get(v).add(new int[]{u,w});
//         }
//         int dist[][] = new int [n][n];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dist[i],Integer.MIN_VALUE);

//         }
        
//         dist[0][0]=succProb[0];
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
//         pq.add(start_node,1,w);
//         while(!pq.isEmpty()){
//             int [] node = pq.remove();
//             int u= node[0];
//             int v= node[1];
//             int w = node[2];
//             for(int [] curr :adj.get(node)){
//                 int newu = curr[0];
//                 int newv= curr[1];
//                 int neww= curr[2];
//                 int total = w*neww;

//                 if(total>dist[newu]){
//                     dist[newu]=total;
//                     pq.add(new int[]{newu, newv, total});
//                 }
//             }
//         }
//         return dist[newu][newv];

        
//     }
// }


class Solution {
    public double maxProbability(int n, int[][] edges,
                                 double[] succProb,
                                 int start_node,
                                 int end_node) {

        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];

            adj.get(u).add(new double[]{v, w});
            adj.get(v).add(new double[]{u, w});
        }

        double[] dist = new double[n];
        dist[start_node] = 1.0;

        PriorityQueue<double[]> pq =
            new PriorityQueue<>((a, b) ->
                Double.compare(b[1], a[1]));

        pq.add(new double[]{start_node, 1.0});

        while (!pq.isEmpty()) {
            double[] node = pq.poll();
            int u = (int) node[0];
            double prob = node[1];

            if (u == end_node) return prob;

            for (double[] neighbor : adj.get(u)) {
                int v = (int) neighbor[0];
                double newProb = prob * neighbor[1];

                if (newProb > dist[v]) {
                    dist[v] = newProb;
                    pq.add(new double[]{v, newProb});
                }
            }
        }

        return 0.0;
    }
}