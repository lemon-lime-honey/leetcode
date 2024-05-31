class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new ArrayDeque<>(), d = new ArrayDeque<>();
        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') r.add(i);
            else d.add(i);
        }

        while (!r.isEmpty() && !d.isEmpty()) {
            if (r.peek() < d.peek()) r.add(n);
            else d.add(n);
            n++;
            r.poll();
            d.poll();
        }

        return r.isEmpty() ? "Dire" : "Radiant";
    }
}