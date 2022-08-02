/*
Merge K sorted Lists.
*/


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists){
        ListNode result = null;
        ListNode tail = null;
        int ct = lists.length;

        if(ct == 0)
            return result;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(ct, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(int i=0; i<ct; i++){
            if(lists[i] != null)
                pq.add(lists[i]);
        }

        while(!pq.isEmpty()){
            ListNode cur = pq.remove();
            ListNode next = cur.next;
            if(next != null)
                pq.add(next);

            if(result == null) {
                result = cur;
                tail = result;
            } else {
                tail.next = cur;
                tail = tail.next;
            }
        }

        return result;
    }

    public static void main(String[] args){
        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(5);

        ListNode ln2 = new ListNode(1);
        ln2.next = new ListNode(3);
        ln2.next = new ListNode(4);

        ListNode ln3 = new ListNode(2);
        ln3.next = new ListNode(6);

        ListNode[] lists = {ln1, ln2, ln3};
        ListNode res = new MergeKLists().mergeKLists(lists);

        while(res != null){
            System.out.print(res.val + ", ");
            res = res.next;
        }

        System.out.println("\ndone ");
    }
}
