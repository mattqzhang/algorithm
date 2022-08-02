/*
Merge K sorted arrays.
Construct a min heap of size K with one element from each array. Each time remove the root and put in target array, and  get the next element from the array of the removed element.
*/

/*
Merge sort k arrays.
In a matrix: each row is sorted, but column is not.
Sort all matrix and output a single sorted array.
 */

class PQNode{
    int val;
    int idx_x;
    int idx_y;

    public PQNode(int val, int idx_x, int idx_y){
        this.val = val;
        this.idx_x = idx_x;
        this.idx_y = idx_y;
    }
}

public class MergeKArrays {
    public static int[] mergeNArrays(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int[] result = new int[m*n];
        int cur = 0;

        if(n==0)
            return result;
        // Create a min heap of size m
        // we can use PriorityQueue for simplicity.
        PriorityQueue<PQNode> pq = new PriorityQueue<PQNode>(m, new Comparator<PQNode>() {
            @Override
            public int compare(PQNode o1, PQNode o2) {
                return o1.val - o2.val;
            }
        });

        // push 1st element of all arrays to PQ.
        for(int i=0; i<m; i++){
            PQNode node = new PQNode(arr[i][0], i, 0);
            pq.add(node);
        }

        // remove head from pq, put val in result, and add next from same row.
        while(!pq.isEmpty()){
            PQNode node = pq.remove();
            result[cur++] = node.val;
            if(node.idx_y + 1 < n) {
                PQNode nextNode = new PQNode(arr[node.idx_x][node.idx_y + 1], node.idx_x, node.idx_y + 1);
                pq.add(nextNode);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int arr[][] = { {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}} ;

        int[] result =  mergeNArrays(arr);
        System.out.println(Arrays.toString(result));

        System.out.println();
    }
}
