class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int u=pre[1];
            int v=pre[0];
            adj.get(u).add(v);
        }
        boolean [] visited = new boolean [numCourses];
        boolean [] path= new boolean[numCourses];
        for(int i =0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(adj,i,visited,path)){
                    return false;
                }
            }
        }
        return true;

        
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr, boolean [] visited, boolean[] path){
        int n =adj.size();
        visited[curr]=true;
        path[curr]=true;
        for(int neb: adj.get(curr)){
            if(!visited[neb]){
                if(dfs(adj,neb,visited,path)){
                    return true;
                }
                
            }else if(path[neb]){
                return true;
            }
        }
        path[curr]=false;
        return false;

    }
}