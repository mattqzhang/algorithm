/*
compute GCD(a, b)

example computation in each iteration:
a   b
65, 45
45, 20
20, 5
5, 0

*/

int computeGCD(int a,int b){    
    if (a < b) 
       swap(a, b);

    if (b==0) 
        return a;
    else 
        return computeGCD(b, a%b);        	
}
