class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int [] col = new int[n];
        for(int i =0;i<n;i++){
            col[i]=-1;
        }
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int neighbor : graph[i]){
                adj.get(i).add(neighbor);
            }
        }

        for(int i =0;i<n;i++){
            if(col[i]==-1){
                if(!bfs(adj,i,col,1)){
                    return false;
                }
            }
        }
        return true;
        

        
    }
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int curr, int[] col, int currcol){

        Queue<Integer> qu = new LinkedList<>();
        qu.add(curr);
        col[curr] = currcol;

        while(!qu.isEmpty()){

            int node = qu.remove();

            for(int i = 0; i < adj.get(node).size(); i++){

                int neighbor = adj.get(node).get(i);  

                if(col[neighbor] == -1){
                    col[neighbor] = 1 - col[node];     
                    qu.add(neighbor);
                }
                else if(col[neighbor] == col[node]){
                    return false;                      
                }
            }
        }

        return true;  
    }
}
// USING ADJACENCY MATRIX

// class Solution {
//     public boolean isBipartite(int[][] graph) {

//         int n = graph.length;
//         int[] col = new int[n];

//         Arrays.fill(col, -1);

//         for(int i = 0; i < n; i++){
//             if(col[i] == -1){
//                 if(!bfs(graph, i, col)){
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }

//     public boolean bfs(int[][] graph, int start, int[] col){

//         Queue<Integer> q = new LinkedList<>();
//         q.add(start);
//         col[start] = 0;

//         while(!q.isEmpty()){
//             int node = q.poll();

//             for(int neighbor : graph[node]){

//                 if(col[neighbor] == -1){
//                     col[neighbor] = 1 - col[node];
//                     q.add(neighbor);
//                 }
//                 else if(col[neighbor] == col[node]){
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// }
