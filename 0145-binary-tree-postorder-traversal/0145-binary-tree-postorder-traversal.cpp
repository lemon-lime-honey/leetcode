class Solution {
    void traverse(TreeNode* node, vector<int>& result) {
        if (node == NULL) return;
        traverse(node->left, result);
        traverse(node->right, result);
        result.push_back(node->val);
    }

public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        traverse(root, result);
        return result;
    }
};