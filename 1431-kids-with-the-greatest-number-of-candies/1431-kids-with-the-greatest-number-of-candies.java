class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int ref = 0;
        List<Boolean> result = new ArrayList<>();

        for (int candy: candies) {
            if (ref < candy) ref = candy;
        }

        for (int candy: candies) {
            if (ref <= candy + extraCandies) result.add(true);
            else result.add(false);
        }

        return result;
    }
}