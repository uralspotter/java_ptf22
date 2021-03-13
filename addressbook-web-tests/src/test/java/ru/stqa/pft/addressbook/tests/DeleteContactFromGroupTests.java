package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;

public class DeleteContactFromGroupTests extends TestBase {

    @Test
    public void contactDeletionFromGroupTest() {
        Contacts contacts = app.db().contacts();
        app.contact().goToGroupPage(contacts);
        app.contact().contactSelectedById(contacts.iterator().next().getId());
        app.contact().removeContactFromGroup();

    }
}
