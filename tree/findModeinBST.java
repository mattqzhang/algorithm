/*
Find Mode in Binary Search Tree

lc 501
https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
*/

    // <val -> freq>
    HashMap<Integer, Integer> hm = new HashMap<>();
    int maxFreq = 0;

    void dfs(TreeNode root) {
        if (root == null) return;

        int freq = hm.getOrDefault(root.val, 0) + 1;
        if (freq > maxFreq) maxFreq = freq;
        hm.put(root.val, freq);
        dfs(root.left);
        dfs(root.right);
    }

    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root);
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == maxFreq)
                list.add(entry.getKey());
        }
        // output
        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

