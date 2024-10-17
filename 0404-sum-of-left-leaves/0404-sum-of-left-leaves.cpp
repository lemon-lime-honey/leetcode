class Solution {
private:
    int result;

    void calc(TreeNode* node, bool left) {
        if (node->left == NULL && node->right == NULL && left) {
            result += node->val;
        }
        if (node->left != NULL) {
            calc(node->left, true);
        }
        if (node->right != NULL) {
            calc(node->right, false);
        }
    }

public:
    int sumOfLeftLeaves(TreeNode* root) {
        result = 0;
        calc(root, false);
        return result;
    }
};