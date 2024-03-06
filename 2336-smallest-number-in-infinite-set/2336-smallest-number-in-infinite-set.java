class SmallestInfiniteSet {
    PriorityQueue<Integer> heap;
    Set<Integer> set;
    int smallest;

    public SmallestInfiniteSet() {
        heap = new PriorityQueue<>();
        set = new HashSet<>();
        smallest = 1;
    }
    
    public int popSmallest() {
        if (!heap.isEmpty() && heap.peek() < smallest) {
            int target = heap.poll();
            set.remove(target);
            return target;
        }
        smallest++;
        return smallest - 1;
    }
    
    public void addBack(int num) {
        if (smallest > num && !set.contains(num)) {
            heap.add(num);
            set.add(num);
        }
    }
}