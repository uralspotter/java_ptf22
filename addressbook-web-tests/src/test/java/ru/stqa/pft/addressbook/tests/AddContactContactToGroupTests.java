package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactContactToGroupTests extends TestBase {

    @Test
    public void addContactToGroupFromContactPage() {
        Contacts contacts = app.db().contacts();
        app.contact().contactSelectedById(contacts.iterator().next().getId());
        app.contact().selectGroup(contacts);
        app.contact().addContactToGroup();
        Contacts contactsafter = app.db().contacts();
        assertThat(contacts.iterator().next(), equalTo(contactsafter.iterator().next()));
    }
}
