class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int [] freq = new int [k];
        for(int x = 0;x<n;x++){
            int i =((arr[x]%k)+k)%k;
            freq[i]++;
        }
        if(freq[0]%2 !=0){
            return false;
        }
        for(int j=1;j<k;j++){
            if(freq[j] != freq[k-j]){
                return false;
            }
        }
        return true;
        
    }
}