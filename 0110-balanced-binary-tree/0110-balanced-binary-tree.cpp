class Solution {
    int chk(TreeNode* node) {
        if (node == NULL) return 0;
        int leftLevel = chk(node->left), rightLevel = chk(node->right);
        if (leftLevel < 0 || rightLevel < 0 || abs(leftLevel - rightLevel) > 1) {
            return -1;
        }
        return max(leftLevel, rightLevel) + 1;
    }

public:
    bool isBalanced(TreeNode* root) {
        return chk(root) > -1;
    }
};