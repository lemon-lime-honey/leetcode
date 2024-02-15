class Solution {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }

        int one = 0, two = 1, three = 1;

        for (int i = 0; i < n - 2; i++) {
            int sum = one + two + three;
            one = two;
            two = three;
            three = sum;
        }

        return three;
    }
}