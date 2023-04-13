/*
Assign Cookies
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

lc 455
https://leetcode.com/problems/assign-cookies/description/
*/

   public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ct = 0;

        int i = 0, j = 0;
        while (i<g.length && j< s.length) {
            // the cookie can satisfy the child, give it.
            if (s[j] >= g[i]) {
                i++;
                j++;
                ct++;
            } else {
                // find the next bigger cookie
                j++;
            }
        }

        return ct;
    }
