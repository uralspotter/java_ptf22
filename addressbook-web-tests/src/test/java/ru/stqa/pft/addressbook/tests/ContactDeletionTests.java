package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test1", "test2", "test3", "test4", "test33@test.33", "test15"), true);
        }
        app.getContactHelper().firstContactSelected();
        app.getContactHelper().contactDelete();
        app.getContactHelper().acceptAlert();
    }
}
