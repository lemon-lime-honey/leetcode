class Pair {
    public String digits;
    public int cnt;

    public Pair(String digits, int cnt) {
        this.digits = digits;
        this.cnt = cnt;
    }
}

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> stop = new HashSet<>();
        Set<String> seen = new HashSet<>();
        Queue<Pair> que = new ArrayDeque<>();

        for (String deadend: deadends) {
            stop.add(deadend);
        }

        seen.add("0000");
        que.add(new Pair("0000", 0));

        while (!que.isEmpty()) {
            String now = que.peek().digits;
            int cnt = que.peek().cnt;
            que.poll();

            if (now.equals(target)) return cnt;
            if (stop.contains(now)) continue;

            for (int i = 0; i < 4; i++) {
                int temp = now.charAt(i) - '0';
                for (int j = -1; j < 2; j += 2) {
                    int newTemp = (temp + j) % 10;
                    if (newTemp < 0) newTemp = 9;
                    String next = now.substring(0, i) + Integer.toString(newTemp) + now.substring(i + 1, 4);
                    if (!seen.contains(next)) {
                        seen.add(next);
                        que.add(new Pair(next, cnt + 1));
                    }
                }
            }
        }

        return -1;
    }
}