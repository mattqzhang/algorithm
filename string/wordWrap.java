/*
perform word wrapping for a given length 

*/

public String wordWrap(String input, int maxLength) {
    String[] words = input.split("\\s+");
    StringBuilder result = new StringBuilder();
    StringBuilder line = new StringBuilder();

    for (String word : words) {
        if (line.length() + word.length() > maxLength) {
            result.append(line.toString().trim()).append("\n");
            line.setLength(0);
        }
        line.append(word).append(" ");
    }

    if (line.length() > 0) {
        result.append(line.toString().trim());
    }

    return result.toString();
}
