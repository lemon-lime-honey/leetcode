class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        ListNode temp = head;
        int size = 0;

        while (temp != null) {
            ++size;
            temp = temp.next;
        }

        int chunk = size / k, left = size % k;

        for (int i = 0; i < k; i++) {
            result[i] = head;
            int size_now = chunk + (left > 0 ? 1 : 0);
            --left;

            for (int j = 0; j < size_now - 1; j++) {
                if (head != null) {
                    head = head.next;
                }
            }

            if (head != null) {
                temp = head.next;
                head.next = null;
                head = temp;
            }
        }

        return result;
    }
}