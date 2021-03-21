package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UIHelper extends HelperBase {

    private ApplicationManager app;

    public UIHelper(ApplicationManager app) {
        super(app);
        wd = app.getDriver();
    }

    public void adminAuth(String login, String password) {
        type(By.name("username"), login);
        click(By.cssSelector("input[type='submit']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[type='submit']"));

    }

    public void goToUsersPage() {
        wd.get(app.getProperty("web.baseUrl") + "manage_user_page.php");
    }

    public void openUserPage(String username) {
        click(By.xpath("a[contains(text(), '" + username + "')]"));
    }

    public void resetUserPassword() {
        click(By.id("manage_user_reset_token"));
    }

    public void changePasswordUser(String changeLink, String password) {
        wd.get(changeLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update_User']"));
    }
}
