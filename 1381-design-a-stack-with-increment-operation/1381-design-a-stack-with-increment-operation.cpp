class CustomStack {
public:
    vector<int> st;
    int idx;

    CustomStack(int maxSize) {
        st.resize(maxSize);
        idx = -1;
    }

    void push(int x) {
        if (idx == -1 || idx < st.size() - 1) {
            idx++;
            st[idx] = x;
        }
    }
    
    int pop() {
        if (idx == -1) {
            return -1;
        }
        return st[idx--];
    }
    
    void increment(int k, int val) {
        for (int i = 0; i < min(k, idx + 1); i++) {
            st[i] += val;
        }
    }
};
