/*
Kids With the Greatest Number of Candies

lc 1431
https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
*/

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new LinkedList<>();
        int max = candies[0];
        for (int i=0; i<candies.length; i++) {
            if (candies[i] > max) max = candies[i];
        }
        for (int i=0; i<candies.length; i++) {
            if (candies[i] + extraCandies >= max)
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }
