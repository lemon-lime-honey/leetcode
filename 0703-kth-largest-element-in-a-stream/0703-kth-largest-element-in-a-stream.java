class KthLargest {
    private PriorityQueue<Integer> nums;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.nums = new PriorityQueue<>();
        this.k = k;

        for (int num: nums) {
            this.nums.offer(num);
        }

        while (this.nums.size() > k) {
            this.nums.poll();
        }
    }
    
    public int add(int val) {
        this.nums.offer(val);

        if (this.nums.size() > this.k) {
            this.nums.poll();
        }

        return this.nums.peek();
    }
}
