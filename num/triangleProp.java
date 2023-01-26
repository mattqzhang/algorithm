/*
Triangle property: given n integers, return 1 if the following condition is true: 
for any i, j, k in this sequence, satisfy the condition: a[i]+a[j]>a[k]; a[i]+a[k]>a[j]; a[j]+a[k]>a[i]

Solution: First sort, then compare every 3 consecutive values if a[i] + a[i+1] > a[i+2]
*/

