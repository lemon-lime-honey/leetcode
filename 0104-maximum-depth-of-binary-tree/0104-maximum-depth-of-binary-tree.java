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
    int result = 0;

    public void search(TreeNode node, int depth) {
        if (node == null) return;
        if (node.left != null) {
            search(node.left, depth + 1);
        }
        if (node.right != null) {
            search(node.right, depth + 1);
        }
        if (result < depth) {
            result = depth;
        }
        return;
    }

    public int maxDepth(TreeNode root) {
        search(root, 1);
        return result;
    }
}