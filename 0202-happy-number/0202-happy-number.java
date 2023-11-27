class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (true) {
            if (seen.contains(n)) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            seen.add(n);
            int temp = 0;

            while (n != 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
        }
    }
}