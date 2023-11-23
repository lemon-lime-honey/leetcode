class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num: nums) {
            if (result.isEmpty()) {
                result.add(num);
                continue;
            }
            if (num > result.get(result.size() - 1)) {
                result.add(num);
                continue;
            }
            int lo = 0;
            int hi = result.size() - 1;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (result.get(mid) < num) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            result.set(lo, num);
        }

        return result.size();
    }
}