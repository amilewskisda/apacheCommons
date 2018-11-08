import org.junit.Test;

public class MailTest {

    // 5000 milliseconds = 5 sec
    @Test(timeout = 5000)
    public void verifyIfEmailWillBeSentIn5Seconds() {
        MailManager.sendEmail();
    }
}
