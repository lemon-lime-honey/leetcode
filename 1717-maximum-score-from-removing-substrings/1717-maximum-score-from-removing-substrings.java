class Solution {
    public int maximumGain(String s, int x, int y) {
        int result = 0;
        String[] chk = {"ab", "ba"};

        if (x < y) {
            String temp = chk[0];
            chk[0] = chk[1];
            chk[1] = temp;

            int tmp = x;
            x = y;
            y = tmp;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == chk[0].charAt(0) && s.charAt(i) == chk[0].charAt(1)) {
                result += x;
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        Stack<Character> newStack = new Stack<>();

        for (int i = 0; i < stack.size(); i++) {
            if (!newStack.isEmpty() && newStack.peek() == chk[1].charAt(0) && stack.get(i) == chk[1].charAt(1)) {
                result += y;
                newStack.pop();
            } else {
                newStack.push(stack.get(i));
            }
        }

        return result;
    }
}