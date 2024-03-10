class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> nums = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        for (int num: nums1) {
            nums.add(num);
        }

        for (int num: nums2) {
            if (nums.contains(num) && !seen.contains(num)) {
                res.add(num);
                seen.add(num);
            }
        }

        int[] result = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}