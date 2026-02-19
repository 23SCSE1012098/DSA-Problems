// class NumArray {

//     public NumArray(int[] nums) {

//        sumRange(0,left,right,nums); 
//     }
    
//     public int sumRange(int i, int left, int right, int[] nums) {
//         if(left<end || right<start){
//             return 0;
//         }
//         else if(left<=start && right<=end){
//             tree[i];
//         }
//         else{
//             int mid =start +(end-start)/2;
//             int leftside =sumRange(2*i+1,left,mid,nums);
//             int rightside=sumRange(2*i+2,mid+1,right,nums);
//             tree[i]=leftside+rightside;
//         }
//         return tree;

        
//     }
// }


class NumArray {

    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[4 * n];   // enough space
        build(nums, 0, 0, n - 1);
    }

    private void build(int[] nums, int index, int start, int end) {
        if (start == end) {
            tree[index] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;

        build(nums, 2 * index + 1, start, mid);        // left child
        build(nums, 2 * index + 2, mid + 1, end);      // right child

        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int index, int start, int end, int left, int right) {

        // No overlap
        if (right < start || left > end) {
            return 0;
        }

        // Complete overlap
        if (left <= start && end <= right) {
            return tree[index];
        }

        // Partial overlap
        int mid = start + (end - start) / 2;

        int leftSum = query(2 * index + 1, start, mid, left, right);
        int rightSum = query(2 * index + 2, mid + 1, end, left, right);

        return leftSum + rightSum;
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */