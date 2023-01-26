/*
Implementation in C also contains: 
- create bitmap
- init all bits to 1/0
- print binary format of bitmap sequentially
*/

#ifndef BITMAP_H_
#define BITMAP_H_

static int wordSize = 8;

int arr_idx(int n) {
    return (int) n / wordSize;
}

int bit_idx(int n) {
    return n % wordSize;
}

void setbit(int word[], int n){
    word[arr_idx(n)] |= 1 << bit_idx(n) ;
}

void clearbit(int word[], int n){
    word[arr_idx(n)] &= ~(1 << bit_idx(n)) ;
}

short getbit(int word[], int n){
    short b = word[arr_idx(n)] & (1 << bit_idx(n)) ;
    return (b == 1) ? 1 : 0;
}

/* create a bitmap that can hold n bits
 * note that the size of the bitmap array is arr_idx(n)+1
 */
int *create_bitmap(int n){
    return calloc((arr_idx(n)+1), wordSize);
}

/* print the binary representation of a bitmap
 * arrCt is the size of the bitmap word[] array
 */
void print_bitmap(int word[], int arrCt){
    int i, j;
    for(i=0; i<arrCt; i++){
        int n = word[i];
        for(j=0; j<wordSize; j++){
            if(n&1)
                printf("1");
            else
                printf("0");
            n >>= 1;
        }
        printf(", ");
    }
}

/* init all bits to 1 */
void init_one(int word[], int arrCt){
    memset(word, 0xFF, sizeof(word)* arrCt);
}

/* init all bits to 0 */
void init_zero(int word[], int arrCt){
    memset(word, 0, sizeof(word)* arrCt);
}

#endif /* BITMAP_H_ */
