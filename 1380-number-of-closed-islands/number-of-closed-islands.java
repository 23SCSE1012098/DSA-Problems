class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        int [][] visited = new int [m][n];
        for(int i =0;i<m;i++){
            dfs(grid,visited,i,0);
            dfs(grid,visited,i,n-1);
        }
        for(int j =0;j<n;j++){
            dfs(grid,visited,0,j);
            dfs(grid,visited,m-1,j);
        }
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && visited[i][j]==0){
                    dfs(grid,visited,i,j);
                    count++;

                }
            }
        }
        return count;

        
    }
    public void dfs(int [][] grid, int [][] visited,int i,int j){
        int m = grid.length;
        int n= grid[0].length;
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==1 || visited[i][j]==1){
            return;
        }
        visited[i][j]=1;
        dfs(grid,visited,i+1,j);
        dfs(grid,visited,i-1,j);
        dfs(grid,visited,i,j+1);
        dfs(grid,visited,i,j-1);
    }
}