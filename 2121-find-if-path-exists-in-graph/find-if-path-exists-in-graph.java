import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        if(source==destination) return true;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean [] visited = new boolean [n];
        bfs(source,adj,visited,destination);
        return visited[destination];

            
    }
    public static void bfs (int curr, ArrayList<ArrayList<Integer>> adj,boolean [] visited,int destination){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);
        visited[curr]=true;
        while(!queue.isEmpty()){
            int node = queue.remove();
            for(int x:adj.get(node)){
                if(!visited[x]){
                    queue.add(x);
                    visited[x]=true;
                    if(curr==destination) return;
                }
            }
        }

    }
}