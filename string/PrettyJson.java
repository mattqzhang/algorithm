/*
Pretty JSON formatting
Pretty print a json object using proper indentation.
1.Every inner brace should increase one indentation to the following lines.
2. Every close brace should decrease one indentation to the same line and the following lines.
3. The indents can be increased with an additional ‘\t
*/

public static String prettyJSON(String str) {
    StringBuilder sb = new StringBuilder();
    int indent = 0;
    char pre = 0;

    for (char c : str.toCharArray()) {
        if (Character.isWhitespace(c))
            continue;
        if (c == ']' || c == '}')
            indent--;

        if (c == '[' || pre == '[' ||c == '{' || pre == '{'|| pre == ',' || c == ']' || c == '}') {
            sb.append('\n');
            for (int i = 0; i < indent; i++)
                sb.append("\t");
        }

        if (c == '[' || c == '{')
            indent++;

        sb.append(c);
        pre = c;
    }
    return sb.toString();
}


/* Driver program to test above functions */
public static void main(String[] args)
{
    //String str = "{\"id\": \"0001\",\t\"type\": \"donut\",\"name\": \"Cake\",\"ppu\": 0.55, \"batters\":{\"batter\":[{ \"id\": \"1001\", \"type\": \"Regular\" },{ \"id\": \"1002\", \"type\": \"Chocolate\" }]},\"topping\":[{ \"id\": \"5001\", \"type\": \"None\" },{ \"id\": \"5002\", \"type\": \"Glazed\" }]}";
    String str = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
    //String str = "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
    String res = prettyJSON(str);
    System.out.println(res);

    System.out.println("done");

}
