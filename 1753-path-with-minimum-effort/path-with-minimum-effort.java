class Solution {
    class Tuple{
        int row;
        int col;
        int distance;
        Tuple(int row, int col, int distance){
            this.row = row;
            this.col=col;
            this.distance=distance;

        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> a.distance-b.distance);
        int n = heights.length;
        int m = heights[0].length;
        int dist[][] = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        pq.add(new Tuple(0,0,0));
        while(!pq.isEmpty()){
            Tuple it = pq.remove();
            int dis=it.distance;
            int row=it.row;
            int col=it.col;
            int [] dr={-1,0,1,0};
            int [] dc={0,1,0,-1};
            if(row==n-1 && col==m-1) return dis;
            for(int i=0;i<4;i++){
                int newrow= row+dr[i];
                int newcol=col+dc[i];
                if(newrow >=0 && newcol>=0 && newrow<n && newcol<m){
                    int Effort= Math.max(Math.abs(heights[row][col]-heights[newrow][newcol]),dis);
                    if(Effort<dist[newrow][newcol]){
                        dist[newrow][newcol]=Effort;
                        pq.add(new Tuple(newrow,newcol,Effort));

                    }
                }
                
            }
        }
        return -1;


        
    }
}