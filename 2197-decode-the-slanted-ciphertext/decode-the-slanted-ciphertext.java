// class Solution {
//     public String decodeCiphertext(String encodedText, int rows) {
//         int n = rows;
//         int m = encodedText.length()/n;
//         String originalText;
//         int matrix [][] = new int [n][m];
//         for(int i=0;i<n;i++){
//             for(int j =0;j<m;j++){
//                 matrix[i][j]=encodedText.charAt(i);

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
//         return originalText;
        
//     }
// }





class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 0) return "";

        int n = rows;
        int m = encodedText.length() / n;

        // Step 1: Fill matrix row-wise
        char[][] matrix = new char[n][m];
        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = encodedText.charAt(k++);
            }
        }

        // Step 2: Traverse diagonally
        StringBuilder result = new StringBuilder();

        for (int col = 0; col < m; col++) {
            int i = 0;
            int j = col;

            while (i < n && j < m) {
                result.append(matrix[i][j]);
                i++;
                j++;
            }
        }

        // Step 3: Remove trailing spaces
        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }

        return result.substring(0, end + 1);
    }
}