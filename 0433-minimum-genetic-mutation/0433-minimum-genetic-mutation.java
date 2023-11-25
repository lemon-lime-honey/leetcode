class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (!Arrays.asList(bank).contains(endGene)) {
            return -1;
        }

        Queue<String> que = new LinkedList<>();
        Set<String> chk = new HashSet<>();
        char[] base = {'A', 'T', 'G', 'C'};
        List<String> vault = Arrays.asList(bank);

        int result = 0;

        chk.add(startGene);
        que.add(startGene);

        while (!que.isEmpty()) {
            for (int i = que.size(); i > 0; i--) {
                String now = que.poll();
                if (now.equals(endGene)) {
                    return result;
                }
                char[] chrs = now.toCharArray();

                for (int j = 0; j < 8; j++) {
                    char original = chrs[j];

                    for (char c: base) {
                        chrs[j] = c;
                        String nextGene = new String(chrs);
                        if (!chk.contains(nextGene) && vault.contains(nextGene)) {
                            chk.add(nextGene);
                            que.add(nextGene);
                        }
                    }

                    chrs[j] = original;
                }
            }
            result++;
        }
        return -1;
    }
}