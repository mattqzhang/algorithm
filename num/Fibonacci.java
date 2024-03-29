/*
Fibonacci: compute it recursively and non-recursively
*/

    //compute Fibonacci non-recursively
    static int Fibonacci_nonrec(int n) {
        if (n == 0)
            return 0;

        int first = 0;
        int second = 1;
        int counter = 2;
        while (counter < n) {
            int temp = second;
            second = first + second;
            first = temp;
            ++counter;
        }
        return first + second;
    }

    //compute Fibonacci recursively
    static int Fibonacci_rec(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        return Fibonacci_rec(n - 1) + Fibonacci_rec(n - 2);
    }

