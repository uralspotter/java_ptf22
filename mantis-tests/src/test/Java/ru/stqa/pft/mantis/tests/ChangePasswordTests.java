package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testChangeUserPassword() throws IOException, MessagingException {
        String email = "test@localhost.localdomain";
        String username = "uralspotter";
        String newpassword = "newUserpassword";
        app.mantis().adminAuth(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        app.mantis().goToUsersPage();
        app.mantis().openUserPage(username);
        app.mantis().resetUserPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String changeLink = findConfirmationLink(mailMessages, email);
        app.mantis().changePasswordUser(changeLink, newpassword);
        assertTrue(app.newSession().login(username, newpassword));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
