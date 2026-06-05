// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix.length;
//         int m = matrix[0].length;
//         for(int i=0;i<n;i++){
//             for(int j =0;j<m;j++){
//                 if(matrix[i][j]==target){
//                     return true;
//                 }
//             }
//         }
//         return false;
        
//     }
// }


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = 0;
        int m = matrix[0].length-1;
        while(n<matrix.length && m>=0){
            if(matrix[n][m]==target){
                return true;
            }
            else if(matrix[n][m]>target){
                m--;
            }
            else{
                n++;
            }
        }
        return false;
        
        
    }
}