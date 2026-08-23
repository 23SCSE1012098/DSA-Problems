class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftsum =0;
        int rightsum = 0;
        int leftcount=0;
        int rightcount=0;
        for(int i=0;i<n;i++){
            if(num.charAt(i)=='?'){
                if(i<n/2){
                  leftcount++;
                }
                else{
                    rightcount++;
                }

            }
            else{
                if(i<n/2){
                    leftsum += num.charAt(i)-'0';
                }
                else{
                    rightsum += num.charAt(i)-'0';
                }
            }
            
        }
        if(((leftcount+rightcount)%2)!=0){
            return true;
        }
        int left = 2*leftsum+9*leftcount;
        int right = 2*rightsum+9*rightcount;
        if(left==right){
            return false;
        }
        return true;
        
    }
}