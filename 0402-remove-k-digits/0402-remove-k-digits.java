class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }

            if (!stack.isEmpty() || num.charAt(i) != '0') {
                stack.push(num.charAt(i));
            }
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append('0');
        } else {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse();
        }

        return sb.toString();
    }
}