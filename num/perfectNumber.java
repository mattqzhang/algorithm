/*
Perfect Number
A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.

lc 507
https://leetcode.com/problems/perfect-number/description/
*/

    public boolean checkPerfectNumber(int num) {
        // cannot include itself;
        if (num == 1) return false;

        int sum = 1;
        for (int i=2; i*i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i*i != num)
                    sum += num / i;
                if (sum > num) return false;
            }
        }

        return (sum == num);
    }
