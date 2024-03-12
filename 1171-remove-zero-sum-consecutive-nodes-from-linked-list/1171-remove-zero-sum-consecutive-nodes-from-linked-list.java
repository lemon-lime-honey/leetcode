class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Map<Integer, ListNode> prefixDict = new HashMap<>();
        prefixDict.put(0, dummy);
        ListNode node = head;
        int prefix = 0;

        while (node != null) {
            prefix += node.val;
            if (prefixDict.containsKey(prefix)) {
                ListNode target = prefixDict.get(prefix).next;
                int tempSum = prefix + target.val;
                while (target != node) {
                    prefixDict.remove(tempSum);
                    target = target.next;
                    tempSum += target.val;
                }
                prefixDict.get(prefix).next = node.next;
            } else {
                prefixDict.put(prefix, node);
            }
            node = node.next;
        }

        return dummy.next;
    }
}