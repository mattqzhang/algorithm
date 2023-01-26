/*
Prime number:
Find all prime number with in n.
- Solution 1: (1) create a prime list, and put 2 as the initial value (2) for every value from 3, check if it can be divided by the numbers in the prime list. If not, it's a new prime, attach it to list.
This solution can also be used to find the k-th prime. Just add a counter and stop when the list is of size k.
- Solution 2 (Sieve of Eratosthenes):  (1) create a bitmap of size n, and init all bits to 1. (2) starting from 2, for each prime p, starting from p^2 unmark all multiples of p. (3) for the next marked bit, repeat step 2.
Check if a number is prime. for each value less than or equal to square root of this number, check if it can be divided.
*/

/* Find the prime number within range [2, n] */
static void findPrime(int n){
    ArrayList<Integer> pList = new ArrayList<Integer>();
    int p = 2;
    pList.add(p);
    int i, j;

    for (i=3; i<=n; i++){
        for(j=0; j<pList.size(); j++){
            int pnum = pList.get(j);
            if(i % pnum == 0)
                break;
        }
        // end of arrylist and there's no factors found
        if(j == pList.size())
            pList.add(i);
    }

    for(i=0; i<pList.size(); i++)
        System.out.print(pList.get(i) + ", ");
    return;
}

//check if a value is prime
static boolean isPrime(int k) {
    if(k < 2)
        return false;
    if (k==2)
        return true;

    if(k%2==0)
        return false;

    for(int i=3; i<=sqrt(k); i+=2) {
        if(k % i == 0)
            return false;
    }
    return true;
}
