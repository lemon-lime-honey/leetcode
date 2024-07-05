class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> points = new ArrayList<>();
        int before = -1, idx = 0;

        while (head != null && head.next != null) {
            if (before != -1 && (
                (head.val < before && head.val < head.next.val) ||
                (head.val > before && head.val > head.next.val)
            )) points.add(idx);

            idx++;
            before = head.val;
            head = head.next;
        }

        if (points.size() < 2) return new int[]{-1, -1};
        int[] result = {Integer.MAX_VALUE, 0};

        for (int i = 1; i < points.size(); i++) {
            result[0] = Math.min(result[0], points.get(i) - points.get(i - 1));
            result[1] = Math.max(result[1], points.get(i) - points.get(0));
        }

        return result;
    }
}