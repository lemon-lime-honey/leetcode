class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if (head == NULL || head->next == NULL) return true;

        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* rev = NULL;

        while (fast != NULL && fast->next != NULL) {
            ListNode* temp = slow;
            slow = slow->next;
            fast = fast->next->next;
            temp->next = rev;
            rev = temp;
        }

        if (fast != NULL) slow = slow->next;

        while (rev != NULL && rev->val == slow->val) {
            rev = rev->next;
            slow = slow->next;
        }

        return rev == NULL;
    }
};