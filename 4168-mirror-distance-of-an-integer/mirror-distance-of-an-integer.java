class Solution {
    public int mirrorDistance(int n) {
        int temp =n;
        int rev  =0;
        while(n>0){
            int digit= n%10;
            rev = rev*10+digit;
            n=n/10;
        }
        
        int ans = Math.abs(temp-rev);
        return ans;
        
    }
}