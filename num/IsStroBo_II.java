/*
Strobogrammatic number:
II: Find all strobogrammatic numbers that are of length = n.
Use recursion and notice that it should recurse with n - 2 instead of n - 1.
Take length 0 and length 1 as base case. For length n, it's generated from length n-2, by adding 1, 8, 6/9, 9/6 to both sides.

lc 247
*/

public ArrayList<String> findStrobo(int m, int n){
    ArrayList<String> list = new ArrayList<String>();

    if (m == 0) {
        list.add("");
        return list;
    }

    if (m == 1) {
        list.add("0");
        list.add("1");
        list.add("8");
        return list;
    }

    // recursion to n-2
    list = findStrobo(n-2, n);

    ArrayList<String> res = new ArrayList<String>();
    for(int i=0; i< list.size(); i++){
        String val = list.get(i);
        // we allow adding 0 to both ends at intermediate stages.
        if(m != n){
            res.add("0" + val + "0");
        }
        res.add("1" + val + "1");
        res.add("8" + val + "8");
        res.add("6" + val + "9");
        res.add("9" + val + "6");
    }
    return res;
}

