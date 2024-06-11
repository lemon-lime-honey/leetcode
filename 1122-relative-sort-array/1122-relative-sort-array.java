class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int[] result = new int[arr1.length];
        PriorityQueue<Integer> left = new PriorityQueue<>();
        int idx = 0;

        for (int num: arr1) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        for (int num: arr2) {
            for (int i = 0; i < cnt.get(num); i++) {
                result[idx++] = num;
            }
            cnt.put(num, 0);
        }

        cnt.forEach((key, value) -> {
            for (int i = 0; i < value; i++) {
                left.add(key);
            }
        });

        while (!left.isEmpty()) {
            result[idx++] = left.poll();
        }

        return result;
    }
}