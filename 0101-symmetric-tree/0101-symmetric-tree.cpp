class Solution {
private:
    bool chk(TreeNode* left, TreeNode* right) {
        if (left == NULL && right == NULL) return true;
        if (left == NULL || right == NULL) return false;

        return left->val == right->val && chk(left->left, right->right) && chk(left->right, right->left);
    }

public:
    bool isSymmetric(TreeNode* root) {
        return chk(root, root);
    }
};