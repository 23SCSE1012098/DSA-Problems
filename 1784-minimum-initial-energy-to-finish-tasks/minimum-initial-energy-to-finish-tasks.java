class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(task1,task2) ->{
            int diff1=task1[1]-task1[0];
            int diff2 = task2[1]-task2[0];
            return diff2-diff1;

        });
        int l =0;
        int r = (int) 1e9;
        int result = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isValid(tasks,mid)){
                result = mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return result;
        
    }
    public static boolean isValid(int [][] tasks,int mid){
        for(int[] task:tasks){
            int actual = task[0];
            int minimum = task[1];
            if(minimum > mid){
                return false;
            }
            mid -= actual;
        }
        return true;

    }
}