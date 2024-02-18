class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> res = new Stack<>();

        for (int asteroid: asteroids) {
            if (res.isEmpty() ||
                res.peek() * asteroid > 0 ||
                res.peek() < 0 && asteroid > 0) {
                res.push(asteroid);
            } else {
                boolean flag = true;
                while (!res.isEmpty() && res.peek() * asteroid < 0) {
                    if (Math.abs(res.peek()) < Math.abs(asteroid)) {
                        res.pop();
                    } else if (Math.abs(res.peek()) == Math.abs(asteroid)) {
                        res.pop();
                        flag = false;
                        break;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.push(asteroid);
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}