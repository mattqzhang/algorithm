/*
Count and Say
*/

   /*
    The count-and-say sequence is the sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

     */
    public static String countAndSay(int n){
        if(n == 0)
            return "";
        if(n == 1)
            return "1";

        String str = "1";
        StringBuilder sb = new StringBuilder();;

        // at each round, read the string from previous output
        while (n > 1){
            char pre = str.charAt(0);
            int ct = 1;
            sb = new StringBuilder();

            for(int i = 1; i < str.length(); i++){
                if(str.charAt(i) == pre){
                    ct++;
                }
                else
                {
                    sb.append(ct);
                    sb.append(pre);
                    pre = str.charAt(i);
                    ct = 1;
                }
            }
            sb.append(ct);
            sb.append(pre);
            str = sb.toString();
            n--;
        }
        return sb.toString();
    }


    /* Driver program to test above functions */
    public static void main(String[] args)
    {
        /*
        for(int n = 0; n<7; n++) {
            System.out.println(countAndSay(n));
        }
        */
        int n = 3;
        System.out.println(countAndSay(n));

        System.out.println("done");

    }
