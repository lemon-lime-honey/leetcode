class Solution {
    public int numSteps(String s) {
        int last = s.length() - 1, carry = 0, result = 0;

        while (last > 0) {
            int chk = s.charAt(last) - '0' + carry;
            if (chk == 0) result++;
            else if (chk == 2) result++;
            else {
                carry = 1;
                result += 2;
            }
            last--;
        }

        if (carry == 1) result++;

        return result;
    }
}