/*
lc 243
https://leetcode.com/problems/shortest-word-distance/

Shortest Word Distance
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
*/

public int shortestDistance(String[] words, String word1, String word2) {
    int i1=-1, i2=-1, dist=0, minDist=words.length;
    for(int i=0; i<words.length; i++){
        if(words[i].equals(word1))
            i1 = i;
        if(words[i].equals(word2))
            i2 = i;

        if(i1 != -1 && i2 != -1) {
            dist = (i1 >= i2) ? i1 - i2 : i2 - i1;
            minDist = Math.min(dist, minDist);
        }
    }
    return minDist;
}
