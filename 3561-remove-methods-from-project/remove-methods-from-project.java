// class Solution {
//     public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
//         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//         int l = invocations.length;
//         int m = invocations[0].length;
//         for(int i =0;i<l;i++){
//             for(int j=0;j<m;j++){
//                 list.get(i).add(j);

//             }
//         }
//         List<Integer> ans = new ArrayList<>();
//         boolean vis [] = new boolean [n];
//         for(int i=0;i<n;i++){
//             if(!vis[i]){
//                 if(dfs(i,-1,vis,list)){
//                     return ans;
//                 }
//                 ans.add(i);
//             }
//         }
//         return ans;

        
//     }
//     public static void dfs(int curr,ArrayList<ArrayList<Integer>> list, int vis[],int parent ){
//         vis[curr]=true;
//         for(int neighbor:list.get(curr)){
//             if(!visited[neighbor]){
//                 if(dfs(neighbor,list,vis,curr)){
//                     return true;
//                 }
//             }
//             else if(neighbor !=parent){
//                 return true;
//             }
//         }
//         return false;

//     }
// }


class Solution {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] suspicious = new boolean[n];

        dfs(k, graph, suspicious);

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] suspicious) {

        suspicious[node] = true;

        for (int next : graph.get(node)) {
            if (!suspicious[next]) {
                dfs(next, graph, suspicious);
            }
        }
    }
}