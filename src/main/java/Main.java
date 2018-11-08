public class Main {
    private static final String SDA_TEXT = "Software Development Academy";
    private static String BECOME_PROGRAMMER_TEXT = "In future I will become a programmer";
    private static String SOFTWARE_DEVELOPER_TEXT = "In future I will become a programmer";

    public static void main(String[] args) {
        testStringUtils();
        CSVTest.writeCSV();
        CSVTest.readCSV();
        MailTest.sendEmail();
    }

    private static void testStringUtils() {
        boolean containsAorB = StringUtilsTest.checkIfContainsAorB(SDA_TEXT);
        System.out.println("Text contains A or B - " + containsAorB);

        boolean sentenceContainsTextIgnoreCase = StringUtilsTest.checkIfSentenceContainsTextIgnoreCase(BECOME_PROGRAMMER_TEXT);
        System.out.println("Sentence contains text ignore case - " + sentenceContainsTextIgnoreCase);

        int numberOfAInText = StringUtilsTest.countLettersInText(SDA_TEXT, 'a');
        System.out.println("There is " + numberOfAInText + " 'a' letters in sentence " + SDA_TEXT);

        String diff = StringUtilsTest.getDifference(SDA_TEXT, SOFTWARE_DEVELOPER_TEXT);
        System.out.println("Difference: " + diff);
    }
}
