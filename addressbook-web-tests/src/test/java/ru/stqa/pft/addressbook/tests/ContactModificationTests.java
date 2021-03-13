package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions() {
        if (! app.contact().isThereAContact()) {
            app.contact().create(new ContactData().withFirstname("test1").withMiddlename("test2").withLastname("test3").withHomePhone("test4").withEmail("test33@test.33").withGroup("test1"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = (ContactData) before.iterator().next();
        ContactData newContactData = new ContactData().withId(modifiedContact.getId()).withFirstname("test1").withMiddlename("test2").withLastname("test3").withHomePhone("test4").withEmail("test33@test.33").withGroup("test1");
        app.contact().modify(newContactData);
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size()));

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(newContactData)));
    }
}
