/*
Copy List with Random Pointer

lc 138
https://leetcode.com/problems/copy-list-with-random-pointer/description/
*/

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node newHead = new Node(head.val);
        Node cur = head;
        Node curNew = newHead;
        // old -> New
        HashMap<Node, Node> hm = new HashMap<>();
        hm.put(head, newHead);

        // go through next list, and create all nodes
        // put mapping nodes in hm
        while (cur.next != null) {
            cur = cur.next;
            Node newNext = new Node(cur.val);
            curNew.next = newNext;
            hm.put(cur, newNext);
            curNew = newNext;
        }
        // go through next list, setup random pointer using hm
        cur = head;
        curNew = newHead;
        while (cur!= null) {
            if (cur.random == null)
                curNew.random = null;
            else {
                curNew.random = hm.get(cur.random);
            }
            cur = cur.next;
            curNew = curNew.next;
        }

        return newHead;
    }
