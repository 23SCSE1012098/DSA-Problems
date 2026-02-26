class Solution {
    public int numberOfSteps(int num) {
        int step=0;
        if(num==0){
          return 0;
        }
        while(num>0){
            if(num%2==1){
                num-=1;
                step++;
            }
            num=num/2;
            step++;
        }
        return step-1;
        
    }
}