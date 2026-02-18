class Solution {
    public int minimumObstacles(int[][] grid) {

        int n= grid.length;
        int m = grid[0].length;
        int [][] dist = new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        pq.add(new int[]{0,0,dist[0][0]});
        while(!pq.isEmpty()){
            int [] curr = pq.remove();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];
            if(r==n-1 && c==m-1){
                return d;
            }
            int [] dr={1,0,-1,0};
            int [] dc={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
            
                if(nr>=0 && nc>=0 && nr<n && nc <m){
                    int nd = d+grid[nr][nc];
                    if(nd<dist[nr][nc]){
                        dist[nr][nc]=nd;
                        pq.add(new int []{nr,nc,dist[nr][nc]});
                    }
                }
            }    
        }

        return -1;
    }
}
        