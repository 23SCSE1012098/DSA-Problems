// class Solution {
//     public int shortestPath(int[][] grid, int k) {

//         int n= grid.length;
//         int m = grid[0].length;
//         boolean [][][] visited = new boolean [41][41][1601];
//         // for(int i=0;i<n;i++){
//         //     for(int j=0;j<n;j++){
//         //         for(int l=0;i<n;l++){
//         //             visited[i][j][l]=false;
//         //         }
//         //     }
//         // }

//         int step=0;
//         Queue<int[]> qu = new LinkedList<>();
        
//         qu.add(new int[]{0,0,k});
        
//         while(!qu.isEmpty()){
//             int [] curr = qu.remove();
//             int r=curr[0];
//             int c=curr[1];
//             int obst=curr[2];
//             if(r==n-1 && c==m-1){
//                 return step;
//             }
//             int [] dr={1,0,-1,0};
//             int [] dc={0,1,0,-1};
//             for(int i=0;i<4;i++){
//                 int nr=r+dr[i];
//                 int nc=c+dc[i];
            
//                 if(nr>=0 && nc>=0 && nr<n && nc <m){
//                     if(grid[nr][nc]==0 && !visited[nr][nc][obst]){
//                         qu.add(new int []{nr,nc,obst});
//                         visited[nr][nc][obst]=true;
                    
//                     }
//                     else if(grid[nr][nc]==1 && k>0 && !visited[nr][nc][obst-1]){
//                         qu.add(new int []{nr,nc,obst-1});
//                         visited[nr][nc][obst-1]=true;
                        

//                     }
//                 }
//             } 
//             step++;   
//         }

//         return -1;
//     }
// }
        

class Solution {
    public int shortestPath(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][][] visited = new boolean[n][m][k + 1];

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{0, 0, k});
        visited[0][0][k] = true;

        int step = 0;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!qu.isEmpty()) {

            int size = qu.size();   // process level by level

            for (int s = 0; s < size; s++) {

                int[] curr = qu.remove();
                int r = curr[0];
                int c = curr[1];
                int obst = curr[2];

                if (r == n - 1 && c == m - 1) {
                    return step;
                }

                for (int i = 0; i < 4; i++) {

                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < m) {

                        // If empty cell
                        if (grid[nr][nc] == 0 && !visited[nr][nc][obst]) {
                            visited[nr][nc][obst] = true;
                            qu.add(new int[]{nr, nc, obst});
                        }

                        // If obstacle and we can eliminate
                        else if (grid[nr][nc] == 1 && obst > 0 
                                 && !visited[nr][nc][obst - 1]) {
                            visited[nr][nc][obst - 1] = true;
                            qu.add(new int[]{nr, nc, obst - 1});
                        }
                    }
                }
            }

            step++;  // increment after finishing one level
        }

        return -1;
    }
}