class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean [] visited= new boolean [n];
        // visited[0]=true;
        bfs(0,rooms,visited);
        for(int i=0;i<n;i++){
            if(visited[i] !=true){
                return false;
            }
        }
        return true;

        
    }
    public static void bfs (int curr, List<List<Integer>> rooms,boolean [] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curr);
        visited[curr]=true;
    
        while(!queue.isEmpty()){
            int node = queue.remove();
            for(int i=0; i < rooms.get(node).size();i++){
                int key = rooms.get(node).get(i);
                if(!visited[key]){
                    queue.add(key);
                    visited[key]=true;
                }
            }
        }

    }
}