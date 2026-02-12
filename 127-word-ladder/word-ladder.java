class Solution {

    class Pair {
        String word;
        int count;

        Pair(String w, int c) {
            word = w;
            count = c;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while (!q.isEmpty()) {

            Pair curr = q.remove();
            String word = curr.word;
            int count = curr.count;

            if (word.equals(endWord)) return count;

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char orgword = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    if (ch == orgword) continue;

                    arr[i] = ch;
                    String newword = new String(arr);

                    if (set.contains(newword)) {
                        q.add(new Pair(newword, count + 1));
                        set.remove(newword);
                    }
                }

                arr[i] = orgword;
            }
        }

        return 0;
    }
}
