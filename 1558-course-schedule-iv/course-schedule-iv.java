class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] x: prerequisites){
            int u = x[0];
            int v = x[1];
            adj.get(u).add(v);
        }
        int q=queries.length;
        boolean visited[] = new boolean[numCourses];
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<q;i++){
            visited = new boolean [numCourses];
            int src=queries[i][0];
            int des=queries[i][1];
            ans.add(dfs(adj,src,des,visited));
        }
        return ans;
 
        
    }
     public boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int dest, boolean[] visited){
        
        if(src == dest) return true;

        visited[src] = true;

        for(int neighbor : adj.get(src)){
            if(!visited[neighbor]){
                if(dfs(adj, neighbor, dest, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}