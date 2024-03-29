import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String s1 = "Hello World!";
        String s2 = "12345";
        String s3 = "email@example.com";
        String s4 = "ABC123DEF";
        String s5 = "abc123xyz";

        // Regular expression patterns
        String p1 = "Hello";
        String p2 = "\\d+";
        String p3 = "\\b\\w+@\\w+\\.\\w+\\b";
        String p4 = "[A-Z]+\\d+[A-Z]+";
        String p5 = "[a-z]+\\d+[a-z]+";

        // Test positive cases
        System.out.println("Positive Cases:");
        testPattern(p1, s1);
        testPattern(p2, s2);
        testPattern(p3, s3);
        testPattern(p4, s4);
        testPattern(p5, s5);

        // Test negative cases
        System.out.println("Negative Cases:");
        testPattern(p1, s2);
        testPattern(p2, s1);
        testPattern(p3, s4);
        testPattern(p4, s2);
        testPattern(p5, s3);
    }

    private static void testPattern(String patternStr, String subjectStr) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(subjectStr);
        boolean found = matcher.find();
        System.out.println("Pattern: " + patternStr + " | Subject: " + subjectStr + " | Match found: " + found);
    }
}