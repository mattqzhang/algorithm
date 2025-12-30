/*
Different Ways to Add Parentheses
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

lc 241:
https://leetcode.com/problems/different-ways-to-add-parentheses/description/
*/

    public int compute (int left, char op, int right) {
        if (op == '+') return left + right;
        if (op == '-') return left - right;
        // op == '*'
        return left * right;
    }

    // expr -> <list of values>
    HashMap<String, List<Integer>> hm = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (hm.containsKey(expression))
            return hm.get(expression);

        List<Integer> res = new LinkedList<>();

        for (int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c== '*') {
                String left_expr = expression.substring(0, i);
                String right_expr = expression.substring(i+1);
                List<Integer> left_vals = diffWaysToCompute(left_expr);
                List<Integer> right_vals = diffWaysToCompute(right_expr);
                for (int left : left_vals) {
                    for (int right : right_vals) {
                        res.add(compute(left, c, right));
                    }
                }
            }
        }
        // single value, no op
        if (res.isEmpty())
            res.add(Integer.parseInt(expression));

        hm.put(expression, res);
        return res;
    }
