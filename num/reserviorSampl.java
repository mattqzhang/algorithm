/*
Reservoir Sampling: Given n element in S[1..n], choose k samples.
- initialize sample array R[1 .. k] to S[1..k]
- for each i in S[k+1 .. n], generate random number j in [1..i]. If j is within k, then put S[i] in R[j]
This solution can be used for dynamic stream data
*/


    static int[] reserviorSampling(int arr[], int K){
        int[] sample = new int [K];
        if(arr.length < K)
            return null;
       
        //initialize sample array to the first K values of input array
        for(int i =0; i<K; i++){
            sample[i] = arr[i];
        }
       
        for(int i=K; i < arr.length; i++){
            //generate a random number in [0, i]
            int rand = (int) (i* Math.random());
            //replace with current one if the number is in the first K
            if(rand < K)
                sample[rand] = arr[i];
        }
       
        return sample;
    }
   
