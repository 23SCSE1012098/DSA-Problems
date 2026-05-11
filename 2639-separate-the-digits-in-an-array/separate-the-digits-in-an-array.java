class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            List<Integer> temp = new ArrayList<>();
            while(n>0){
                temp.add(n%10);
                n=n/10;
            }
            for(int j=temp.size()-1;j>=0;j--){
                list.add(temp.get(j));
            }
        }
        
        
        int [] ans = new int [list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
        
    }
}