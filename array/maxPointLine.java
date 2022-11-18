/*
lc 149
https://leetcode.com/problems/max-points-on-a-line/

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
*/

int[][] points;
int n;
// mapping of slope -> count
HashMap<Double, Integer> lines = new HashMap<Double, Integer>();
// doesn't have slope, save the count separately
int horisontal_lines;

/**
Add a line passing through i and j points.
Update max number of points on a line containing point i (max on slope or horizontal).
Update a number of duplicates of i point.
*/
public Pair<Integer, Integer> add_line(int i, int j, int count, int duplicates) {
    // rewrite points as coordinates
    int x1 = points[i][0];
    int y1 = points[i][1];
    int x2 = points[j][0];
    int y2 = points[j][1];
    // add a duplicate point
    if ((x1 == x2) && (y1 == y2))
        duplicates++;
    // add a horisontal line : y = const
    else if (y1 == y2) {
        horisontal_lines += 1;
        count = Math.max(horisontal_lines, count);
    }
    // add a line : x = slope * y + c
    // only slope is needed for a hash-map since we always start from the same point
    else {
        double slope = 1.0 * (x1 - x2) / (y1 - y2) + 0.0;
        lines.put(slope, lines.getOrDefault(slope, 1) + 1);
        count = Math.max(lines.get(slope), count);
    }
    return new Pair(count, duplicates);
}

/**
 * Compute the max number of points for a line containing point i.
 * */
public int max_points_on_a_line_containing_point_i(int i) {

    // init lines passing through point i
    lines.clear();
    horisontal_lines = 1;
    // One starts with just one point on a line : point i.
    int count = 1;
    // There is no duplicates of a point i so far.
    int duplicates = 0;

    // Compute lines passing through point i (fixed) and point j (interation).
    // Update in a loop the number of points on a line and the number of duplicates of point i.
    for (int j = i + 1; j < n; j++) {
        Pair<Integer, Integer> p = add_line(i, j, count, duplicates);
        count = p.getKey();
        duplicates = p.getValue();
    }
    return count + duplicates;
}

public int maxPoints(int[][] points) {
    this.points = points;
    // If the number of points is less than 3 they are all on the same line.
    n = points.length;
    if (n < 3)
        return n;

    int max_count = 1;
    // Compute in a loop a max number of points on a line containing point i.
    for (int i = 0; i < n - 1; i++)
        max_count = Math.max(max_points_on_a_line_containing_point_i(i), max_count);
    return max_count;
}
