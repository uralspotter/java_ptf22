package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions() {
        if (! app.contact().isThereAContact()) {
            app.contact().create(new ContactData().withFirstname("test1").withMiddlename("test2").withLastname("test3").withHomePhone("test4").withEmail("test33@test.33").withGroup("test1"));
        }
    }

    @Test
    public void testContactPhone() {
        app.goTo().gotoHomePage();
        ContactData contact = (ContactData) app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    public String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()).stream().filter((s -> !s.equals(""))).map(ContactPhoneTests::cleaned).collect(Collectors.joining("\n"));
    }
}
