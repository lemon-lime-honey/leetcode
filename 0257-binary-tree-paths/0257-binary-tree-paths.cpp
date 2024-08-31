class Solution {
    vector<string> result;

    void dfs(TreeNode* node, string route) {
        route += to_string(node->val);
        if (node->left == NULL && node->right == NULL) {
            result.push_back(route);
            return;
        }
        route += "->";
        if (node->left != NULL) {
            dfs(node->left, route);
        }
        if (node->right != NULL) {
            dfs(node->right, route);
        }
    }

public:
    vector<string> binaryTreePaths(TreeNode* root) {
        dfs(root, "");
        return result;
    }
};