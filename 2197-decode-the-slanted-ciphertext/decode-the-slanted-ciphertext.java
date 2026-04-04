// class Solution {
//     public String decodeCiphertext(String encodedText, int rows) {
//         int n = rows;
//         int m = encodedText.length()/n;
//         if(rows==1) return encodedText;
//         String originalText="";
//         char matrix [][] = new char [n][m];
//         int k=0;
//         for(int i=0;i<n;i++){
//             for(int j =0;j<m;j++){
//                 matrix[i][j]=encodedText.charAt(k++);

//             }
//         }
//         for(int col=0;col<m;col++){
//             int i=0;
//             int j = col;
//             while(i<n && j<m){
//                 originalText += matrix[i][j];
//                 i++;
//                 j++;
//             }
//         }
//         int end = originalText.length() - 1;
//         while (end >= 0 && originalText.charAt(end) == ' ') {
//             end--;
//         }

//         return originalText.substring(0, end + 1);
        
//     }
// }





// class Solution {
//     public String decodeCiphertext(String encodedText, int rows) {
//         if (rows == 0) return "";

//         int n = rows;
//         int m = encodedText.length() / n;

//         // Step 1: Fill matrix row-wise
//         char[][] matrix = new char[n][m];
//         int k = 0;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 matrix[i][j] = encodedText.charAt(k++);
//             }
//         }

//         // Step 2: Traverse diagonally
//         StringBuilder result = new StringBuilder();

//         for (int col = 0; col < m; col++) {
//             int i = 0;
//             int j = col;

//             while (i < n && j < m) {
//                 result.append(matrix[i][j]);
//                 i++;
//                 j++;
//             }
//         }

//         // Step 3: Remove trailing spaces
//         int end = result.length() - 1;
//         while (end >= 0 && result.charAt(end) == ' ') {
//             end--;
//         }

//         return result.substring(0, end + 1);
//     }
// }




class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 0) return "";
        if (rows == 1) return encodedText;

        int n = rows;
        int l = encodedText.length();
        int m = l / n;

        StringBuilder sb = new StringBuilder();

        for (int col = 0; col < m; col++) {
            for (int j = col; j < l; j += (m + 1)) {
                sb.append(encodedText.charAt(j));
            }
        }

        // remove trailing spaces
        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') {
            end--;
        }

        return sb.substring(0, end + 1);
    }
}