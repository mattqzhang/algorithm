/*
DFS and BFS to Serialize and DeSerialize a binary tree to/from String
*/

/****************** DFS ******************/

public String serialize_dfs(TreeNode root, String str) {
    // Recursive serialization.
    if (root == null) {
        str += "null,";
    } else {
        str += str.valueOf(root.val) + ",";
        str = serialize_dfs(root.left, str);
        str = serialize_dfs(root.right, str);
    }
    return str;
}

// Encodes a tree to a single string.
public String serialize(TreeNode root) {
    return serialize_dfs(root, "");
}

public TreeNode deserialize_dfs(List<String> dataList) {
    // Recursive deserialization.
    if (dataList.get(0).equals("null")) {
        dataList.remove(0);
        return null;
    }

    TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
    dataList.remove(0);
    root.left = deserialize_dfs(dataList);
    root.right = deserialize_dfs(dataList);

    return root;
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    String[] arr = data.split(",");
    List<String> dataList = new LinkedList<String>(Arrays.asList(arr));
    return deserialize_dfs(dataList);
}

/****************** BFS ******************/

    public String serialize(TreeNode root) {
        if (root == null) return "";
        String nl = "null", sep = ",";
        Queue<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        TreeNode cur;
        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            cur = dq.poll();
            if (cur != null) {
                sb.append(cur.val);
                dq.offer(cur.left);
                dq.offer(cur.right);
            } else {
                sb.append(nl);
            }
            sb.append(sep);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] vals = data.split(",");
        if (vals == null || vals.length == 0) return null;

        String nl = "null";
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        TreeNode cur, next;
        Deque<TreeNode> dq = new ArrayDeque<>();
        int index = 1;
        dq.offer(root);

        while (!dq.isEmpty()) {
            cur = dq.poll();

            for (int j = index; j < index + 2 && j < vals.length; ++j) {
                if (vals[j].equals(nl)) {
                    if (j % 2 == 1) {
                        cur.left = null;
                    } else {
                        cur.right = null;
                    }
                } else {
                    next = new TreeNode(Integer.parseInt(vals[j]));
                    dq.offer(next);
                    if (j % 2 == 1) {
                        cur.left = next;
                    } else {
                        cur.right = next;
                    }
                }
            }
            index += 2;
        }

        return root;
    }
