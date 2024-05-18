class Solution {
    private int result;

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int lCoin = dfs(node.left);
        int rCoin = dfs(node.right);
        int coins = node.val - 1 + lCoin + rCoin;
        result += Math.abs(coins);
        return coins;
    }

    public int distributeCoins(TreeNode root) {
        result = 0;
        dfs(root);
        return result;
    }
}