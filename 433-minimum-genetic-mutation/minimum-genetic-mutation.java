class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        HashSet<String> set = new HashSet<>(Arrays.asList(bank));

        if (!set.contains(endGene)) {
            return -1;
        }

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(startGene);
        visited.add(startGene);

        int level = 0;
        char[] genes = {'A', 'C', 'G', 'T'};

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                String curr = queue.poll();

                if (curr.equals(endGene)) {
                    return level;
                }

                char[] arr = curr.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char old = arr[i];

                    for (char ch : genes) {

                        if (ch == old) continue;

                        arr[i] = ch;

                        String neighbor = new String(arr);

                        if (!visited.contains(neighbor) && set.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.add(neighbor);
                        }
                    }

                    arr[i] = old;
                }
            }

            level++;
        }

        return -1;
    }
}