class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int res[] = new int [numCourses];
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
                if(dfs(adj,i,st,visited,path)){
                    return new int[]{};
                }
            }
        }
        int index=0;
        while(!st.isEmpty()){
            res[index++]=st.pop();
        }

        return res;

        
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int curr,Stack<Integer> st, boolean [] visited, boolean[] path){
        int n =adj.size();
        visited[curr]=true;
        path[curr]=true;
        for(int neb: adj.get(curr)){
            if(!visited[neb]){
                if(dfs(adj,neb, st, visited,path)){
                    return true;
                }
                
            }else if(path[neb]){
                return true;
            }
        }
        path[curr]=false;
        st.push(curr);
        return false;

    }
}
        