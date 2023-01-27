/*
Factor Combinations
Write a function that takes an integer n and return all possible combinations of its factors.

lc 254
*/

public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res;
    res = new ArrayList();
    dfs(res, new ArrayList(), n);
    return res;
}

   // factors is actually a stack here, to save the factors visited before
    public void dfs(List<List<Integer>> res, List<Integer> factors, int n) {
        if(n==1) return;
        for(int i=2; i<=Math.sqrt(n); i++){
            // k is the previous factor checked
            int k = factors.isEmpty() ? 1 : factors.get(factors.size()-1);
            // if (i<k), then we hav visited i before
            if(n % i==0 && i >= k){
                List<Integer> copy = new ArrayList(factors);
                copy.add(i);
                copy.add(n/i);
                res.add(copy);

                // further factor (n/i), so save i as the latest factor
                // note: we can actually use a stack to save factors here
                factors.add(i);
                dfs(res, factors, n/i);
                // all factors of n/i checked, pop i.
                factors.remove(factors.size()-1);
            }
        }
    }
