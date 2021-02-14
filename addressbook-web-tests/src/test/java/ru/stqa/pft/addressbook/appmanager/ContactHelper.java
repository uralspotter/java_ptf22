package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase  {

    private NavigationHelper navigationHelper = new NavigationHelper(wd);

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
       click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("email"), contactData.getLastName());
        if (creation) {
            if (contactData.getGroup() != null) {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void firstContactSelected() {
        click(By.name("selected[]"));
    }

    public void contactDelete() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@title='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isThereAContact() {
        if (isElementPresent(By.name("selected"))) {
            return true;
        } else {
            return false;
        }
    }

    public void createContact(ContactData contactData, boolean creation) {
        initContactCreation();
        fillContactForm(contactData, creation);
        submitContactCreation();
        navigationHelper.returnToContactPage();
    }
}
