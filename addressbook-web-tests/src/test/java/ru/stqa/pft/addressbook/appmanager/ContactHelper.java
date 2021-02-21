package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

    public void initContactModification(int index) {
        wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
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

    public void createContact(ContactData contactData, boolean creation) {
        initContactCreation();
        fillContactForm(contactData, creation);
        submitContactCreation();
        navigationHelper.returnToContactPage();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contactDataList = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element: elements) {
            String firstname = element.findElement(By.xpath("//td[3]")).getText();
            String lastname = element.findElement(By.xpath("//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("id"));
            ContactData contact = new ContactData(id, firstname, null, lastname, null, null, null);
            contactDataList.add(contact);
        }
        return contactDataList;
    }
}
