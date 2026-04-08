import java.util.*;

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        
        // pair array: {plantTime[i], growTime[i]}
        int[][] vec = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            vec[i][0] = plantTime[i];
            vec[i][1] = growTime[i];
        }
        
        // sort by growTime in descending order
        Arrays.sort(vec, (a, b) -> b[1] - a[1]);
        
        int prevPlantDays = 0;
        int maxBloomDays = 0;
        
        for (int i = 0; i < n; i++) {
            int currPlantTime = vec[i][0];
            int currGrowTime = vec[i][1];
            
            prevPlantDays += currPlantTime;
            
            int currPlantBloomTime = prevPlantDays + currGrowTime;
            
            maxBloomDays = Math.max(maxBloomDays, currPlantBloomTime);
        }
        
        return maxBloomDays;
    }
}