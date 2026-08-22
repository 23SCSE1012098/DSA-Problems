class Solution {
    public boolean checkDivisibility(int n) {
        int temp =n;
        int sum=0;
        int product=1;
        while(n>=1){
            sum +=n%10;
            product *=n%10;
            n=n/10;
        }
        if((temp)%(sum+product)==0){
            return true;
        }
        return false;
        
    }
}