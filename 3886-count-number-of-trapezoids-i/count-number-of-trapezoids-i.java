class Solution {
    public int countTrapezoids(int[][] points) {
        long MOD=1000000007;
        Map<Integer,Integer> countByY = new HashMap <>();
        for(int[] p: points){
            countByY.put(p[1],countByY.getOrDefault(p[1],0)+1);
        }
        List<Integer> ycord = new ArrayList <>(countByY.keySet());
        Collections.sort(ycord);
        List<Long> hplanes = new ArrayList<>();
        for(int y : ycord){
            long c = countByY.get(y);
            if(c>=2){
                hplanes.add(c*(c-1)/2);
            }else{
                hplanes.add(0L);
            }
        }
        long prefix =0;
        long result = 0;
        for(long n:hplanes){
            result = (result + prefix *(n%MOD))%MOD;
            prefix = (prefix + n)%MOD;
        }
        return (int) result;
        
    }
}