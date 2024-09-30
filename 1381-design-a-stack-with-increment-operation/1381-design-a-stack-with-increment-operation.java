class CustomStack {
    int[] stack;
    int idx;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        idx = 0;

        for (int i = 0; i < maxSize; i++) {
            stack[i] = -1;
        }
    }
    
    public void push(int x) {
        if (idx < stack.length) {
            stack[idx] = x;
            idx++;
        }
    }
    
    public int pop() {
        if (stack[0] == -1) return -1;
        int result = stack[idx - 1];
        stack[idx - 1] = -1;
        idx--;
        return result;
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, idx); i++) {
            stack[i] += val;
        }
    }
}
