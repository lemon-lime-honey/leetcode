class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Integer> d = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0; i < profit.length; i++) {
            if (!map.containsKey(difficulty[i])) {
                d.add(difficulty[i]);
            }
            map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i]));
        }

        Collections.sort(d);
        int mProfit = 0;

        for (int i = 0; i < d.size(); i++) {
            mProfit = Math.max(mProfit, map.get(d.get(i)));
            map.put(d.get(i), mProfit);
        }

        for (int w: worker) {
            int lo = 0, hi = d.size() - 1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (d.get(mid) <= w) lo = mid + 1;
                else hi = mid - 1;
            }

            if (hi >= 0) result += map.get(d.get(hi));
        }

        return result;
    }
}