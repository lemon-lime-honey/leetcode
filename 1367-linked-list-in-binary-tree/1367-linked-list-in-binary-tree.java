class Solution {
    private boolean chk(ListNode listNode, TreeNode treeNode) {
        if (listNode == null) return true;
        if (treeNode == null || listNode.val != treeNode.val) return false;
        return chk(listNode.next, treeNode.left) || chk(listNode.next, treeNode.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        if (chk(head, root)) return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}