class Solution {
private:
    int result;

    void calc(TreeNode* node, int total) {
        if (node->left == NULL && node->right == NULL) {
            result += total;
            return;
        }
        if (node->left != NULL) {
            calc(node->left, total * 10 + node->left->val);
        }
        if (node->right != NULL) {
            calc(node->right, total * 10 + node->right->val);
        }
    }

public:
    int sumNumbers(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        result = 0;
        calc(root, root->val);
        return result;
    }
};