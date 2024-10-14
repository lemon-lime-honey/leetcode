class Solution {
private:
    int result;

    void find(TreeNode* node, int level) {
        if (node->left == NULL && node->right == NULL) {
            result = min(result, level);
            return;
        }

        if (node->left != NULL) {
            find(node->left, level + 1);
        }

        if (node->right != NULL) {
            find(node->right, level + 1);
        }
    }

public:
    int minDepth(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }

        result = INT_MAX;
        find(root, 1);
        return result;
    }
};