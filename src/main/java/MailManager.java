import org.apache.commons.mail.*;

import java.net.MalformedURLException;
import java.net.URL;

public class MailManager {

    // to solve issue org.apache.commons.mail.EmailException: Sending the email to the following server failed : smtp.gmail.com:465
    // https://myaccount.google.com/lesssecureapps

    // SMTP (ang. Simple Mail Transfer Protocol) – protokół komunikacyjny opisujący sposób przekazywania poczty elektronicznej w Internecie.

    private static final String HOST = "smtp.gmail.com"; // dla yahoo smtp.mail.yahoo.com
    private static final int PORT = 465;
    private static final boolean SSL_FLAG = true;

    public static void sendEmail() {
        try {
            EmailAttachment attachment = prepareAttachment();
            MultiPartEmail email = new MultiPartEmail();
            email.setHostName(HOST);
            email.setSmtpPort(PORT);
            email.setSSLOnConnect(SSL_FLAG);
            email.setAuthenticator(new DefaultAuthenticator("TYPE_USER_NAME", "TYPE_PASSWORD")); // userName type simply email
            email.addTo("TYPE_MAIL_TO");
            email.setFrom("TYPE_MAIL_FROM", "name");
            email.setSubject("Picture for you");
            email.setMsg("Hey! I Send to you SDA picture :)");
            email.attach(attachment);
            email.send();
        } catch (Exception ex) {
            System.out.println("Unable to send email");
            System.out.println(ex);
        }
    }

    private static EmailAttachment prepareAttachment() throws MalformedURLException {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setURL(new URL("https://www.newseria.pl/files/_uploaded/glownekonf_1073062514.png")); // google grafika -> otwórz grafikę w nowej karcie -> kopiuj link
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("Logo here");
        attachment.setName("SDA logo");
        return attachment;
    }
}
