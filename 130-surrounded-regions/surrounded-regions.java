// class Solution {
//     public void solve(char[][] board) {
//         int m = board.length;
//         int n = board[0].length;
//         for(int i=0; i<m-1;i++, int j=0){
//             if(board[i][j]=='0'){
//                 dfs(board,visited);
//             }
            
//         }
//         for(int j=0; j<n-1;j++, int i=0){
//             if(board[i][j]=='0'){
//                 dfs(board,visited);
//             }
            
//         }

        
//     }
//     public void dfs(int[][] board,int[] visited,int node){
//         visited[node]=0;
//         if(!visited[node]){
//             visited[node]=1;
//             dfs(board,visited,node);
//         }
        

//     }
// }

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(board, visited, i, 0);
            dfs(board, visited, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(board, visited, 0, j);
            dfs(board, visited, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (board[i][j] != 'O' || visited[i][j]) return;

        visited[i][j] = true;

        dfs(board, visited, i + 1, j);
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i, j + 1);
        dfs(board, visited, i, j - 1);
    }
}
