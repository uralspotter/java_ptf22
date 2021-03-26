package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeletionContactFromGroupTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("name").withHeader("header").withFooter("footer"));
        }
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstname("test").withLastname("test"));
        }
        Contacts contacts = app.db().contacts();
        if(contacts.stream().iterator().next().getGroups().size() == 0) {
            app.contact().contactSelectedById(contacts.iterator().next().getId());
            app.contact().selectGroup(contacts);
            app.contact().addContactToGroup();
            app.goTo().gotoHomePage();
        }
    }

    @Test
    public void contactDeletionFromGroupTest() {
        Contacts contacts = app.db().contacts();
        app.contact().goToGroupPage(contacts);
        app.contact().contactSelectedById(contacts.iterator().next().getId());
        app.contact().removeContactFromGroup();
        Contacts contactsafter = app.db().contacts();
        assertThat(contacts.iterator().next(), equalTo(contactsafter.iterator().next()));

    }
}
