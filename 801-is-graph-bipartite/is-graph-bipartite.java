// class Solution {
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         int m = graph[0].length;
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         int [] col = new int[n];
//         for(int i =0;i<n;i++){
//             col[i]=-1;
//         }
//         for(int i =0;i<n;i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int [] x : graph){
//             for(int j=0;j<x.length;j++){
//                 int u = x[j];
//                 int v = x[j+1];
//                 adj.get(u).add(v);
//             }
            
//         }
//         for(int i =0;i<n;i++){
//             if(col[i]==-1){
//                 if(bfs(adj,i,col)){
//                     return true;
//                 }
//             }
//         }
//         return false;
        

        
//     }
//     public boolean bfs(ArrayList<ArrayList<Integer>> adj , int curr, int [] col){
//         Queue<Integer> qu = new LinkedList<>();
//         qu.add(curr);
//         col[curr]=0;
//         while(!qu.isEmpty()){
//             curr = qu.remove();
//             for(int i =0;i<adj[curr].size();i++){
//                 qu.remove(curr);
//                 if(col[i]!=0 || col[i]!=1){
//                     col[i]=1;
//                     if(col[curr]==col[i]){
//                         return false;
//                     }
//                 }
//             }
//         }    
//     }
// }


// USING ADJACENCY MATRIX

class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] col = new int[n];

        Arrays.fill(col, -1);

        for(int i = 0; i < n; i++){
            if(col[i] == -1){
                if(!bfs(graph, i, col)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfs(int[][] graph, int start, int[] col){

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        col[start] = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbor : graph[node]){

                if(col[neighbor] == -1){
                    col[neighbor] = 1 - col[node];
                    q.add(neighbor);
                }
                else if(col[neighbor] == col[node]){
                    return false;
                }
            }
        }

        return true;
    }
}
