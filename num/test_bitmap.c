/*
test the bitmap.h implementations
*/

#include<stdio.h>
#include "bitmap.h"

int main(){

    int n = 12;
    int *bitmap = create_bitmap(n);

    int aid = arr_idx(n);
    int bid = bit_idx(n);
    printf("aid = %d, bid = %d\n", aid, bid);

    setbit(bitmap, n);
    setbit(bitmap, 2);
    setbit(bitmap, 3);
    int i;
    printf("\nbitmap is: \n\t");
    for(i= arr_idx(n); i>=0; i--)
        printf("%x, ", bitmap[i]);

    printf("\nbitmap in binary is: \n\t");
    print_bitmap(bitmap, aid+1);

    printf("\ninit all bits to 1: \n\t");
    init_one(bitmap, aid+1);
    print_bitmap(bitmap, aid+1);

    printf("\ninit all bits to 0: \n\t");
        init_zero(bitmap, aid+1);
        print_bitmap(bitmap, aid+1);

   return 0;
}
