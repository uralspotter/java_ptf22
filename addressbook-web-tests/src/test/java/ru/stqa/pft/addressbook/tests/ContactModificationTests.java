package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test1", "test2", "test3", "test4", "test33@test.33", null), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test77", "test66", "test55", "test44", "test33@test.33", null), false);
        app.getContactHelper().submitContactModification();
    }
}
