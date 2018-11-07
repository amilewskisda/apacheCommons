import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
    // The StringUtils class provides methods for null-safe operations on strings.
    public static boolean checkIfContainsAorB(String text) {
        return StringUtils.containsAny(text, 'A', 'B');
    }

    public static boolean checkIfSentenceContainsTextIgnoreCase(String sentence) {
        return StringUtils.containsIgnoreCase(sentence, "PROGRAMMER");
    }

    public static int countLettersInText(String text, char letter) {
        return StringUtils.countMatches(text, letter);

        // without lib

/*
        int counter = 0;
        for( int i=0; i<text.length(); i++ ) {
            if( text.charAt(i) == letter ) {
                counter++;
            }
        }*/
    }

    public static String getDifference(String text1, String text2) {
        return StringUtils.difference(text1, text2);
    }
}
