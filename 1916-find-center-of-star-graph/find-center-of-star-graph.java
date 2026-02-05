class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        HashMap<Integer,Integer> freqmap = new HashMap<Integer,Integer>();
        for(int i=0; i<n ;i++){
            int v1=edges[i][0];
            int v2=edges[i][1];
            freqmap.put(v1,freqmap.getOrDefault(v1,0)+1);
            freqmap.put(v2,freqmap.getOrDefault(v2,0)+1);
            if(freqmap.get(v1)==n){
                return v1;
            }
            if(freqmap.get(v2)==n){
                return v2;
            }


        }
        return -1;
        
    }
}