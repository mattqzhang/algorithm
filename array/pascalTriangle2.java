/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

lc 119
https://leetcode.com/problems/pascals-triangle-ii/description/
*/

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new LinkedList<>();
        row.add(1);
        if (rowIndex == 0) {
            return rwo;
        }
        row.add(1);
        if (rowIndex == 1) {
            return row;
        }

        for (int i=2; i<=rowIndex; i++) {
            List<Integer> result = new LinkedList<>();
            result.add(1);
            for (int j=0; j<row.size()-1; j++) {
                result.add(row.get(j) + row.get(j+1));
            }
            result.add(1);
            row = result;
        }
        return row;
    }
