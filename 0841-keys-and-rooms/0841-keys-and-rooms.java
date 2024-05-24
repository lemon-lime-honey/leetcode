class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] chk = new boolean[rooms.size()];
        Queue<Integer> key = new LinkedList<>();
        chk[0] = true;
        key.add(0);

        while (!key.isEmpty()) {
            int now = key.poll();
            for (int i = 0; i < rooms.get(now).size(); i++) {
                if (!chk[rooms.get(now).get(i)]) {
                    key.add(rooms.get(now).get(i));
                    chk[rooms.get(now).get(i)] = true;
                }
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (!chk[i]) return false;
        }

        return true;
    }
}