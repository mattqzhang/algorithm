/*
Simplify Path
Simplify unix path. Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
*/

public class SimplifyPath {

    public String simplifyPath(String path) {
        int len = path.length();
        if (len <=1 )
            return "/";

        String res = "";

        String[] folders = path.split("/");
        Stack<String> st = new Stack<String>();
        for(int i=0; i<folders.length; i++){
            String cur = folders[i];
            if(cur.equals(".") || cur.equals(""))
                continue;
            else if(cur.equals("..")) {
                if(!st.empty())
                    st.pop();
                else
                    continue;
            }else
                st.push(cur);
        }
        if(!st.empty())
            res = st.pop();

        while(!st.empty())
            res = st.pop() + "/" + res;
        res = "/" + res;
        return res;
    }

    public static void main(String[] args){

        String a = "/a//b////c/d//././/..";
        //String a = "/../";
        //String a = "/home/";
        //String a = "/home//foo/";
        //String a = "/a/./b/../../c/";
        //String a = "/a/../../b/../c//.//";
        System.out.println(new SimplifyPath().simplifyPath(a));

        System.out.println("\ndone ");
    }
}
