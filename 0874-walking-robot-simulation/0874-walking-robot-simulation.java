class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, d = 0, result = 0;

        Set<String> obs = new HashSet<>();

        for (int[] obstacle: obstacles) {
            obs.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int command: commands) {
            if (command > 0) {
                for (int i = 0; i < command; i++) {
                    int nx = x + direction[d][0], ny = y + direction[d][1];
                    if (obs.contains(nx + "," + ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    result = Math.max(result, x * x + y * y);
                }
            } else if (command == -1) {
                d = (d + 1) % 4;
            } else {
                d = (d + 3) % 4;
            }
        }

        return result;
    }
}