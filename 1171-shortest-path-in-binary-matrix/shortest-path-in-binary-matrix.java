class Solution {
    public class Pair{
        int row;
        int col;
        int distance;
        Pair(int row, int col, int distance){
            this.row=row;
            this.col=col;
            this.distance=distance;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1){
            return -1;
        }
        PriorityQueue<Pair>  pq = new PriorityQueue<>((a,b)-> a.distance-b.distance);
        int [][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        pq.offer(new Pair(0,0,1));
        dist[0][0]=1;
        while(!pq.isEmpty()){
            Pair it=pq.poll();
            int dis=it.distance;
            int row=it.row;
            int col=it.col;
            int [] dr = {1,0,1,-1,0,-1,1,-1};
            int [] dc = {1,1,0,0,-1,-1,-1,1};
            if(row==n-1 && col==m-1) return dis;
            for(int i=0;i<8;i++){
                int newrow = row+dr[i];
                int newcol = col+dc[i];
                if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && grid[newrow][newcol]==0){
                    int newdis = dis + 1;

                    if (newdis < dist[newrow][newcol]) {
                        dist[newrow][newcol] = newdis;
                        pq.offer(new Pair(newrow, newcol, newdis));
                    }
                }
                
            }
            
        }
        return -1;

        
    }
}