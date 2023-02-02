/*
Two Strings are within one edit
Given two strings s1 and s2, decide if they are within one edit (modify/insert/delete a char)
Solution: 
1. if |len1 - len2| > 1, return false.  
2. let s1 be the string with smaller length. let a pointer start from each string. 
   when encountering the difference, skip both(if same length), or skip s2(if s2 has an extra), 
   then continue to the end and should always match, otherwise return false.
*/

boolean oneEdit(Sting s1, String s2){
  int len1 = s1.length();
  int len2 = s2.length();
  
  // make s1 the shorter length string
  if(len1 >= len2){
    String tmp = s1;
    s1 = s2;
    s2 = tmp;
  }
  if(len2 - len1 > 1)
     return false;

  int i=0, j=0;
  while(s1.charAt(i) == s2.charAt(j) && i<len1-1 && j<len2-1){
    i++;
    j++;
  }
  if(len1 == len2){ //skip the unmatched word
     i++;
     j++
  } else { // s2 has an extra char
    j++;
  }
  while(i<len1-1 && j<len2-j){
    if(s1.charAt(i) == s2.charAt(j){
      i++;
      j++;
    }else {
       return false;
    }    
  }
  return true;
}

