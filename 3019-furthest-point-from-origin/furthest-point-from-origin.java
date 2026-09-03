class Solution {
    public int furthestDistanceFromOrigin(String moves) {

        int L = 0;
        int R = 0;
        int blank = 0;

        for (int i = 0; i < moves.length(); i++) {

            if (moves.charAt(i) == 'L') {
                L++;
            }
            else if (moves.charAt(i) == 'R') {
                R++;
            }
            else {
                blank++;
            }
        }

        return Math.abs(R - L) + blank;
    }
}