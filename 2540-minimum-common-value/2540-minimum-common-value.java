class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int result = Integer.MAX_VALUE;
        int one = 0, two = 0;

        while (one < nums1.length && two < nums2.length) {
            if (nums1[one] == nums2[two]) {
                result = nums1[one];
                break;
            } else if (nums1[one] < nums2[two]) {
                one++;
            } else {
                two++;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}