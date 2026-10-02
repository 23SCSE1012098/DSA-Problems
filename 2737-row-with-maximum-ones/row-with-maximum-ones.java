class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int ans [] = new int [2];
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0;i<n;i++){
            int count =0;
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            if(count>ans[1]){
                ans[0]=i;
                 ans[1]=count;

            }
            
        }
        return ans;
        
    }
}