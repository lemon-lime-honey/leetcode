class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;

        if (root == NULL) return result;

        queue<TreeNode*> que;
        que.push(root);

        while (!que.empty()) {
            vector<int> temp;
            int n = que.size();

            for (int i = 0; i < n; i++) {
                TreeNode* node = que.front();
                que.pop();
                temp.push_back(node->val);

                if (node->left != NULL) que.push(node->left);
                if (node->right != NULL) que.push(node->right);
            }

            result.push_back(temp);
        }

        return result;
    }
};