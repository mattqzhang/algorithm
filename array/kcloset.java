/*
K Closet points to origin
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
*/

public int getDist(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
}

public int[][] kClosest(int[][] points, int K) {
    int dist[] = new int[points.length];
    for(int i=0; i<points.length; i++)
        dist[i] = getDist(points[i]);

    int[] copy = dist.clone();
    Arrays.sort(dist);
    int distK = dist[K-1];

    int[][] res = new int[K][2];
    int j = 0;
    for(int i=0; i<dist.length; i++){
        if(copy[i] <= distK){
            res[j][0] = points[i][0];
            res[j][1] = points[i][1];
            j++;
        }
    }
    return res;
}
