class Solution {
public:
    vector<double> averageOfLevels(TreeNode* root) {
        queue<TreeNode*> que;
        vector<double> result;

        que.push(root);

        while (!que.empty()) {
            int n = que.size();
            double total = 0.0;

            for (int i = 0; i < n; i++) {
                total += que.front()->val;
                if (que.front()->left != NULL) {
                    que.push(que.front()->left);
                }
                if (que.front()->right != NULL) {
                    que.push(que.front()->right);
                }
                que.pop();
            }
            result.push_back(total / n);
        }

        return result;
    }
};