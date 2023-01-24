#include <stdio.h>


void copyval(int *s, int *t){
  *t = *s;
}

void copy(int *s, int *t){
    t = s;
}

void copyaddr(int *s, int **t){
    *t = s;
}

int main(int argc, char **argv) {

    int a =1, b =2 ;
    int *pa = &a;
    int *pb = &b;

    copyval(pa, pb);
    printf("copy value: %d, %d, (%d, %d)\n", a, b, *pa, *pb);

    b=2;
    printf("reset value: %d, %d, (%d, %d)\n\n", a, b, *pa, *pb);

    // in order to copy the content pa points to, into which pb points to,
    // simply copy pa's content into pb's content doesn't work here,
    // as the copy function will make a local copy instead of doing
    // the assignment for the orignal addresses
    copy(pa, pb);
    printf("copy pointer: %d, %d, (%d, %d)\n", a, b, *pa, *pb);
    *pa = 5;
    printf("update *pa: %d, %d, (%d, %d)\n\n", a, b, *pa, *pb);

    //in order to let pb point to the same address of pa,
    //we need to copy pa to where the address of pb points to
    copyaddr(pa, &pb);
    printf("copy address: %d, %d, (%d, %d)\n", a, b, *pa, *pb);
    //now pa and pb are pointers on the same address,
    //so change the content pa points to, also changes pb's.
    *pa = 8;
    printf("update *pa: %d, %d, (%d, %d)\n", a, b, *pa, *pb);

    return 0;
}
