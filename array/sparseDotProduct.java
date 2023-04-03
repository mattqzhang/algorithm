/*
lc 1570

Dot Product of Two Sparse Vectors
Given two sparse vectors, compute their dot product.
*/

class SparseVector {

    List<int[]> data = new ArrayList<int[]>();
    SparseVector(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                // <index, val>
                int[] entry = new int[]{i, nums[i]};
                data.add(entry);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        int i = 0, j = 0;
        List<int[]> data1 = vec.data;
        while (i < data.size() && j < data1.size()) {
            if (data.get(i)[0] < data1.get(j)[0])
                i++;
            else if (data.get(i)[0]  > data1.get(j)[0] )
                j++;
            else {
                sum += data.get(i)[1] * data1.get(j)[1];
                i++;
                j++;
            }
        }
        return sum;
    }
}
