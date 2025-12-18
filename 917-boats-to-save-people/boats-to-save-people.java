import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Sort weights
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            // If lightest + heaviest fit, pair them
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // Heaviest always takes a boat
            right--;
            boats++;
        }

        return boats;
    }
}
