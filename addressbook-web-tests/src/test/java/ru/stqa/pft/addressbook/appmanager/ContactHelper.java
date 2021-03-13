package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
        attach(By.name("photo"), contactData.getPhoto());
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

    public void contactDelete() {
        click(By.xpath("//input[@value='Delete']"));
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
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void delete(ContactData contact) {
        contactSelectedById(contact.getId());
        contactDelete();
        acceptAlert();
        navigationHelper.returnToContactPage();
    }

    private void contactSelectedById(int id) {
        wd.findElement(By.cssSelector(String.format("input[id='%s']", id))).click();
    }

    public Contacts all() {
        Contacts contact = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        //System.out.println("rows count into method all " + rows.size());
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.name("selected[]")).getAttribute("id"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            contact.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails));
        }
        return  contact;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        String emailfirst = wd.findElement(By.name("email")).getAttribute("value");
        String emailsecond = wd.findElement(By.name("email2")).getAttribute("value");
        String emailthird = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address).withEmail(emailfirst).withEmailSecond(emailsecond).withEmailThird(emailthird);
    }

    public int count() {
        return wd.findElements(By.name("entry")).size();
    }
}
