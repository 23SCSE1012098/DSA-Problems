// class Solution {
//     public boolean areSimilar(int[][] mat, int k) {
        
//         int m = mat.length;
//         int n = mat[0].length;
//         int [][] ans = new int [m][n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 ans[i][j]=mat[i][j];
//             }
//         }
//         k = k%n;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(i%2==0){
//                     mat[i][j]=ans[i][(j+k)%n]; //left shift
                    
//                 }
//                 else{
//                     mat[i][j] = ans[i][(j - k + n) % n]; // right shift
//                 }
//             }
//         }
//         for(int i=0;i<m;i++){
//             for(int j =0;j<n;j++){
//                 if(mat[i][j]!=ans[i][j]){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

// }


class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        
        int m = mat.length;
        int n = mat[0].length;
        k = k%n;
        if(k==0) return true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int curr =j;
                int futureIdx;
                if(i%2==0){
                    futureIdx=(j+k)%n; //left shift
                    
                }
                else{
                    futureIdx=(j - k + n) % n; // right shift
                }
                if(mat[i][curr]!=mat[i][futureIdx]){
                    return false;
                }
            }
        }

        return true;
    }

}