/*
lc 605
https://leetcode.com/problems/can-place-flowers/

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
*/

public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (n == 0)
        return true;
    if (flowerbed.length == 0)
        return false;

    int ct = 0;
    for (int i = 0; i < flowerbed.length; i++) {
        if (flowerbed[i] == 0
                && (i == 0 || flowerbed[i - 1] == 0)
                && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
            flowerbed[i] = 1;
            ct++;
            if (ct == n)
                return true;
            i++;
        }
    }
    return false;
}
