package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UIHelper extends HelperBase {

    private final ApplicationManager app;

    public UIHelper(ApplicationManager app) {
        super(app);
        this.app = app;
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
        click(By.linkText(username));
    }

    public void resetUserPassword() {
        click(By.cssSelector("input[value='Сбросить пароль']"));
    }

    public void changePasswordUser(String changeLink, String password) {
        wd.get(changeLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("button[type='submit']"));
    }
}
