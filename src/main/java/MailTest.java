import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class MailTest {

    // to solve issue org.apache.commons.mail.EmailException: Sending the email to the following server failed : smtp.gmail.com:465
    // https://myaccount.google.com/lesssecureapps

    // SMTP (ang. Simple Mail Transfer Protocol) – protokół komunikacyjny opisujący sposób przekazywania poczty elektronicznej w Internecie.

    private static final String HOST = "smtp.gmail.com"; // dla yahoo smtp.mail.yahoo.com
    private static final int PORT = 465;
    private static final boolean SSL_FLAG = true;

    public static void sendEmail() {
        try {
            Email email = new SimpleEmail();
            email.setHostName(HOST);
            email.setSmtpPort(PORT);
            email.setAuthenticator(new DefaultAuthenticator("userName", "password")); // userName type simply email
            email.setSSLOnConnect(SSL_FLAG);
            email.setFrom("fromAddress");
            email.setSubject("subject");
            email.setMsg("message");
            email.addTo("toAddress");
            email.send();
        } catch (Exception ex) {
            System.out.println("Unable to send email");
            System.out.println(ex);
        }
    }
}
