package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test1", "test2", "test3", "test4", "test33@test.33", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().firstContactSelected(before.size() - 1);
        app.getContactHelper().contactDelete();
        app.getContactHelper().acceptAlert();
        app.getNavigationHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size() - 1, after.size());

        before.remove(before.size() - 1);
        Comparator<? super ContactData> byId = (contact1, contact2) -> Integer.compare(contact1.getId(), contact2.getId());
        after.sort(byId);
        before.sort(byId);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
