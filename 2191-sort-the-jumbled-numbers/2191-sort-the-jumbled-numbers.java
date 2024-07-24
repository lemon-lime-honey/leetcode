class Trio implements Comparable<Trio> {
    int val;
    int ref;
    int idx;

    public Trio(int val, int ref, int idx) {
        this.val = val;
        this.ref = ref;
        this.idx = idx;
    }

    public int compareTo(Trio o) {
        if (this.ref < o.ref) {
            return -1;
        } else if (this.ref > o.ref) {
            return 1;
        } else if (this.idx < o.idx) {
            return -1;
        } else if (this.idx > o.idx) {
            return 1;
        }
        return 0;
    }
}

class Solution {
    private int getVal(int n, int[] mapping) {
        String target = Integer.toString(n);
        int res = 0;

        for (int i = 0; i < target.length(); i++) {
            res = res * 10 + mapping[target.charAt(i) - '0'];
        }

        return res;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Trio[] temp = new Trio[nums.length];
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temp[i] = new Trio(nums[i], getVal(nums[i], mapping), i);
        }

        Arrays.sort(temp);

        for (int i = 0; i < nums.length; i++) {
            result[i] = temp[i].val;
        }

        return result;
    }
}