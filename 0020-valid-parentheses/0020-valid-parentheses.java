import java.util.ArrayList;

class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        HashMap<Character, Character> parentheses = new HashMap<>();

        parentheses.put(')', '(');
        parentheses.put('}', '{');
        parentheses.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (parentheses.containsValue(s.charAt(i))) {
                stack.add(s.charAt(i));
            } else {
                if (!stack.isEmpty() && stack.get(stack.size() - 1) == parentheses.get(s.charAt(i))) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}