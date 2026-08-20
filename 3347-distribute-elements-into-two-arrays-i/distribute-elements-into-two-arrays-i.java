class Solution {
    public int[] resultArray(int[] nums) {
        int n  = nums.length;
        int [] arr1 = new int [n];
        int [] arr2 = new int [n];
        arr1[0]=nums[0];
        arr2[0]=nums[1];
        int p=1;
        int q=1;
        for(int i=2; i< n;i++){
            if(arr1[p-1] > arr2[q-1]){
                arr1[p] = nums[i];
                p++;
            }
            else{
                arr2[q]=nums[i];
                q++;
            }    

        }
        int result []= new int [n];
        int pos =0;
        for(int i=0;i<p;i++){
            result[pos]=arr1[i];
            pos++;
        }
        for(int j=0;j < q;j++){
            result[pos]=arr2[j];
            pos++;
        }
        return result;
    }
}