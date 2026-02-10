class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean [] visited = new boolean [n];
        boolean [] one_path = new boolean[n];
        for(int i =0;i<n;i++){
            if(!visited[i]){
                dfs(graph,i,visited,one_path);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!one_path[i]){
                ans.add(i);
            }
        }
        return ans;

        
    }
    public boolean dfs(int [][] graph, int curr,boolean [] visited, boolean [] one_path){
        visited[curr]=true;
        one_path[curr]=true;
        for(int neb: graph[curr]){
            if(!visited[neb]){
                if(dfs(graph,neb,visited,one_path)){
                    return true;
                }
                
                
            }
            else if(one_path[neb]){
                return true;
            }

        }
        one_path[curr]=false;
        return false;
    }
}