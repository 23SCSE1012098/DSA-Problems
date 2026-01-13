class Solution {
    public int[][] generateMatrix(int n) {
        int [][] ans= new int [n][n];
        int minrow=0;
        int maxrow=n-1;
        int mincol=0;
        int maxcol=n-1;
        int count=1;
        while(count<=n*n){
            for(int c=mincol;c<=maxcol;c++){
                ans[minrow][c]=count;
                count++;
            }
            for(int r=minrow+1;r<=maxrow;r++){
                ans[r][maxcol]=count;
                count++;

            }
            for(int c=maxcol-1;c>=mincol;c--){
                ans[maxrow][c]=count;
                count++;
            }
            for(int r=maxrow-1;r>=minrow+1;r--){
                ans[r][mincol]=count;
                count++;
            }
            mincol++;
            maxcol--;
            minrow++;
            maxrow--;

        }
        return ans;
        
    }
}