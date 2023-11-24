class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.size() != right.size()) {
            left.add(-1 * num);
        } else {
            right.add(num);
        }
        if (!left.isEmpty() && right.peek() < -1 * left.peek()) {
            int n1 = -1 * left.poll();
            int n2 = right.poll();
            left.add(-1 * n2);
            right.add(n1);
        }
    }

    public double findMedian() {
        double result;

        if (left.size() == right.size()) {
            result = (-1 * left.peek() + (double)right.peek()) / 2;
        } else {
            result = right.peek();
        }
        return result;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */