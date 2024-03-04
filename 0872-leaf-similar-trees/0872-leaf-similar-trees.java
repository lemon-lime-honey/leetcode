/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void getSequence(TreeNode node, List<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        if (node.left != null) {
            getSequence(node.left, list);
        }
        if (node.right != null) {
            getSequence(node.right, list);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();
        getSequence(root1, seq1);
        getSequence(root2, seq2);

        return seq1.equals(seq2);
    }
}