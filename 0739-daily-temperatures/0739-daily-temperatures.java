class Pair {
    int temperature;
    int index;

    public Pair(int temperature, int index) {
        this.temperature = temperature;
        this.index = index;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peek().temperature < temperatures[i]) {
                while (!stack.isEmpty() && stack.peek().temperature < temperatures[i]) {
                    Pair now = stack.pop();
                    answer[now.index] = i - now.index;
                }
            }
            stack.push(new Pair(temperatures[i], i));
        }

        return answer;
    }
}