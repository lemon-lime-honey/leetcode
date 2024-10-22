class Solution {
public:
    long long kthLargestLevelSum(TreeNode* root, int k) {
        queue<TreeNode*> que;
        que.push(root);

        priority_queue<long long, vector<long long>, greater<long long>> result;

        while (!que.empty()) {
            int n = que.size();
            long long levelSum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode* node = que.front();
                levelSum += node->val;
                que.pop();

                if (node->left != NULL) {
                    que.push(node->left);
                }
                if (node->right != NULL) {
                    que.push(node->right);
                }
            }

            result.push(levelSum);
            if (result.size() > k) {
                result.pop();
            }
        }

        if (result.size() < k) return -1;

        return result.top();
    }
};