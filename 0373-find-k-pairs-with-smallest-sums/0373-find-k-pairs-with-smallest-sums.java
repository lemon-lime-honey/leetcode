class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        List<List<Integer>> result = new ArrayList<>();

        for (int num: nums1) {
            pq.offer(new int[]{num + nums2[0], 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] now = pq.poll();
            List<Integer> temp = new ArrayList<>();

            temp.add(now[0] - nums2[now[1]]);
            temp.add(nums2[now[1]]);
            result.add(temp);

            if (now[1] + 1 < nums2.length) {
                pq.offer(new int[]{now[0] - nums2[now[1]] + nums2[now[1] + 1], now[1] + 1});
            }

            k--;
        }

        return result;
    }
}