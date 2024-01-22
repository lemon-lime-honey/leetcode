class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minimum;

    public MinStack() {
        stack = new Stack<>();
        minimum = new Stack<>();
    }
    
    public void push(int val) {
        if (minimum.isEmpty()) {
            minimum.add(val);
        } else {
            minimum.add(Math.min(val, minimum.get(minimum.size() - 1)));
        }
        stack.add(val);
    }
    
    public void pop() {
        minimum.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimum.peek();
    }
}