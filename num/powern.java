/*
Power(n,x)
Implement pow(x, n), which calculates x raised to the power n (x^n).
*/

double splitPower(double x, int n){
    if(n==0)
        return 1;

    double half = splitPower(x, n/2);
    if(n % 2 == 0)
        return half * half;
    else
        return half * half * x;
}

public double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
        x = 1 / x;
        N = -N;
    }

    return splitPower(x, n);
}
