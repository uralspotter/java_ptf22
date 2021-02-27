package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void firstContactSelected(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void contactDelete() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void initContactModification(int id) {
        wd.findElements(By.xpath("//img[@title='Edit']")).get(id).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isThereAContact() {
        if (isElementPresent(By.name("selected[]"))) {
            return true;
        } else {
            return false;
        }
    }

    public void create(ContactData newContactData) {
        initContactCreation();
        fillContactForm(newContactData, true);
        submitContactCreation();
        navigationHelper.returnToContactPage();
    }

    public void modify(ContactData newContactData) {
        initContactModificationById(newContactData.getId());
        fillContactForm(newContactData, false);
        submitContactModification();
        navigationHelper.gotoHomePage();
    }

    private void initContactModificationById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    public void delete(ContactData contact) {
        contactSelectedById(contact.getId());
        contactDelete();
        acceptAlert();
        navigationHelper.returnToContactPage();
    }

    private void contactSelectedById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public Contacts all() {
        Contacts contact = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element: elements) {
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("id"));
            contact.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return  contact;
    }
}
