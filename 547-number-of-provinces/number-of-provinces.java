// class Solution {
//     public int findCircleNum(int[][] isConnected) {
//         int n = isConnected.length;
//         boolean [] visited = new boolean[n];
//         int count=0;
//         for(int i=0; i<n; i++){
//             if(!visited[i]){
//                 count++;
//                 dfs(i,isConnected,visited,n);
//             }
//         }
//         return count;
        
//     }
//     public void dfs(int node, int[][] isConnected, boolean[] visited,int n){
//         visited[node]=true;
//         for(int i=0;i<n;i++){
//             if(isConnected[node][i]==1 && !visited[i]){
//                 dfs(i,isConnected,visited,n);
//             }
//         }
//     }
// }

// using DSU ----

class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int count = 0;

        // Check every city
        for (int i = 0; i < n; i++) {

            // New province found
            if (!visited[i]) {

                bfs(i, isConnected, visited);

                count++;
            }
        }

        return count;
    }

    public void bfs(int start, int[][] isConnected, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        visited[start] = true;

        while (!q.isEmpty()) {

            int node = q.remove();

            for (int i = 0; i < isConnected.length; i++) {

                // Connected and not visited
                if (isConnected[node][i] == 1 && !visited[i]) {

                    q.add(i);

                    visited[i] = true;
                }
            }
        }
    }
}