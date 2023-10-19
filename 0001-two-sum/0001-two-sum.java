import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numDict = new HashMap<>();
        int[] result = {0, 0};

        for (int i = 0; i < nums.length; i++) {
            numDict.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (numDict.containsKey(target - nums[i])) {
                if (i != numDict.get(target - nums[i])) {
                    result[0] = i;
                    result[1] = numDict.get(target - nums[i]);
                    break;
                }
            }
        }

        return result;
    }
}