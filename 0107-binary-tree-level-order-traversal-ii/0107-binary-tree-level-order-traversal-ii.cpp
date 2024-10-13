class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> result;

        if (root == NULL) return result;

        stack<vector<int>> vals;
        queue<TreeNode*> que;
        que.push(root);

        while (!que.empty()) {
            int n = que.size();
            vector<int> temp;

            for (int i = 0; i < n; i++) {
                TreeNode* now = que.front();
                temp.push_back(now->val);
                que.pop();

                if (now->left != NULL) {
                    que.push(now->left);
                }
                if (now->right != NULL) {
                    que.push(now->right);
                }
            }

            vals.push(temp);
        }

        while (!vals.empty()) {
            result.push_back(vals.top());
            vals.pop();
        }

        return result;
    }
};