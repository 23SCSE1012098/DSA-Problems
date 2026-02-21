class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        HashSet<Integer> primes = new HashSet<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        for(int i=left;i<=right;i++){
            int count= Integer.bitCount(i);
            if(primes.contains(count)){
                ans++;
            }
        }
        return ans;
        
    }
}


