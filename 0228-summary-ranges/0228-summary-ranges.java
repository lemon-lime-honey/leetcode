class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            }
            if (start == nums[i - 1]) {
                result.add(Integer.toString(start));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(Integer.toString(start));
                sb.append("->");
                sb.append(Integer.toString(nums[i - 1]));
                result.add(sb.toString());
            }
            start = nums[i];
        }

        if (start == nums[nums.length - 1]) {
            result.add(Integer.toString(start));
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(start));
            sb.append("->");
            sb.append(Integer.toString(nums[nums.length - 1]));
            result.add(sb.toString());
        }

        return result;
    }
}