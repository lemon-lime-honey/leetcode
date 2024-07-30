class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (stack.isEmpty() || stack.peek() >= s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                result++;
            }
        }

        return result;
    }
}