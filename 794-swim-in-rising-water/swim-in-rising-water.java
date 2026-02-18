class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] cost = new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cost[i][j]=Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        cost[0][0]=grid[0][0];
        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int row = curr[0];
            int col= curr[1];
            int cos = curr[2];
            int[] dr ={-1,0,1,0};
            int[] dc ={0,-1,0,1};
            if(row==n-1 && col==m-1){
                return cos;
            }
            for(int i=0;i<4;i++){
                int newr= row+dr[i];
                int newc= col+dc[i];
                
                if(newr>=0 && newc>=0 && newr<n && newc<m){
                    int max= Math.max(cos , grid[newr][newc]);
                    if(max < cost[newr][newc]){
                        cost[newr][newc]=max;
                        pq.add(new int[]{newr,newc,max});
                    }
                
                }
            }
        }
        return -1;

        
    }
}