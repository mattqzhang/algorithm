/*
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 
*/

public String toGoatLatin(String S) {
    HashSet<Character> vowls = new HashSet<Character>();
    vowls.add('a');
    vowls.add('e');
    vowls.add('i');
    vowls.add('o');
    vowls.add('u');
    StringBuilder sb = new StringBuilder();

    String[] words = S.split("\\s+");
    for(int i=0; i<words.length; i++){
        String word = words[i];
        if(vowls.contains(word.toLowerCase().charAt(0))){
            word += "ma";
        }else{
            char ch = word.charAt(0);
            word = word.substring(1);
            word = word + ch;
            word = word + "ma";
        }
        for(int j=0; j<=i; j++){
            word += "a";
        }
        word += " ";
        sb.append(word);
    }
    sb.setLength(sb.length() - 1);
    return sb.toString();
}
