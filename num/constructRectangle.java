/*
Construct the Rectangle
The area of the rectangular web page you designed must equal to the given target area.
The width W should not be larger than the length L, which means L >= W.
The difference between length L and width W should be as small as possible.

lc 492
https://leetcode.com/problems/construct-the-rectangle/description/
*/


    public int[] constructRectangle(int area) {
        int L = area, W = 1;
        int Lf = L, Wf = W;
        while (L >= W) {
            if (L * W == area) {
                Lf = L;
                Wf = W;
                L --;
            } else if (L * W > area)
                L --;
            else 
                W++;
        }
        return new int[]{Lf, Wf};        
    }
