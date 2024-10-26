class MinStack {
public:
    stack<int> stk;
    stack<int> minimum;

    MinStack() {
        return;
    }
    
    void push(int val) {
        if (minimum.empty()) {
            minimum.push(val);
        } else {
            minimum.push(min(val, minimum.top()));
        }
        stk.push(val);
    }
    
    void pop() {
        minimum.pop();
        stk.pop();
    }
    
    int top() {
        return stk.top();
    }
    
    int getMin() {
        return minimum.top();
    }
};
