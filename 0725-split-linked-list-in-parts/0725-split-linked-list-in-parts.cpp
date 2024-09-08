class Solution {
public:
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        vector<ListNode*> result(k);
        ListNode* temp = head;
        int size = 0;

        while (temp != NULL) {
            ++size;
            temp = temp->next;
        }

        int chunk = size / k, left = size % k;

        for (int i = 0; i < k; i++) {
            result[i] = head;
            int size_now = chunk + (left > 0 ? 1 : 0);
            --left;

            for (int j = 0; j < size_now - 1; j++) {
                if (head != NULL) {
                    head = head->next;
                }
            }

            if (head != NULL) {
                temp = head->next;
                head->next = NULL;
                head = temp;
            }
        }

        return result;
    }
};