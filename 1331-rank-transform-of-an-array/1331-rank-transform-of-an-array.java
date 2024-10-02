class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        int[] sortedWithoutDuplicate = Arrays.stream(arr).distinct().sorted().toArray();
        int[] result = new int[arr.length];

        for (int i = 0; i < sortedWithoutDuplicate.length; i++) {
            rankMap.put(sortedWithoutDuplicate[i], i + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}