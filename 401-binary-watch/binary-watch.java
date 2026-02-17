class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for(int h=0;h<12;h++){
            for(int m=0;m<60;m++){
                int totalBit = Integer.bitCount(h)+Integer.bitCount(m);
                if(totalBit==turnedOn){
                    ans.add(h + ":" + String.format("%02d",m));
                }

            }
        }
        return ans;
        
    }
}