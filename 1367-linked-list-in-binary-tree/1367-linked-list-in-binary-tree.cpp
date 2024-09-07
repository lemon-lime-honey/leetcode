class Solution {
    bool chk(ListNode* listNode, TreeNode* treeNode) {
        if (listNode == NULL) return true;
        if (treeNode == NULL || listNode->val != treeNode->val) return false;
        return chk(listNode->next, treeNode->left) || chk(listNode->next, treeNode->right);
    }

public:
    bool isSubPath(ListNode* head, TreeNode* root) {
        if (root == NULL) return false;
        if (chk(head, root)) return true;
        return isSubPath(head, root->left) || isSubPath(head, root->right);
    }
};