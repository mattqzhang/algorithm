/*
Text Justification
Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
*/

public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> res = new ArrayList<>();
    if (words == null) return res;
    // l, r are the boundary of the window that constitutes one line
    int l = 0, r = 0;
    while (l < words.length) {
        int len = 0;

        // calculate the window of words that constitutes one line
        while (r < words.length && len + words[r].length() <= maxWidth)
            len += words[r++].length() + 1;  // +1 for whitespace

        int space = 1, extra = 0;
        // calculate the space between words, except last line, or single word line
        if (r != words.length && r != l + 1) {
            // avg space per word
            space = (maxWidth - len + 1) / (r - l - 1) + 1;
            // extra ones cannot be divided
            extra = (maxWidth - len + 1) % (r - l - 1);
        }
        StringBuilder sb = new StringBuilder(words[l++]);
        // add space between words
        while (l < r) {
            for (int i = 0; i < space; i++)
                sb.append(' ');
            // insert extra ones to each word in sequence
            if (extra-- > 0)
                sb.append(' ');
            sb.append(words[l++]);
        }

        /*
        add space at the end of the line if
        - only one word in a line
        - the last line is encountered
        Otherwise we have: maxWidth == sb.length()
          */
        int remaining = maxWidth - sb.length();
        while (remaining-- > 0)
            sb.append(' ');
        res.add(sb.toString());
    }
    return res;
}
