class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        long ans =0;
        if(n==1){
            return 1;
        }
        for(int i=1;i<=n;i++){
            int digit = (int)(Math.log(i) / Math.log(2)) + 1;
            ans = ((ans<<digit)%mod + i)%mod;
            
        }
        return (int)ans;
        
    }
}