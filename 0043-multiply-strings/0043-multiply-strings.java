class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i > -1; i--) {
            for (int j = num2.length() - 1; j > -1; j--) {
                result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j] += result[i + j + 1] / 10;
                result[i + j + 1] %= 10;
            }
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        for (int n: result) {
            if (n != 0) {
                flag = true;
            }
            if (flag) {
                sb.append(n);
            }
        }

        return sb.toString();
    }
}