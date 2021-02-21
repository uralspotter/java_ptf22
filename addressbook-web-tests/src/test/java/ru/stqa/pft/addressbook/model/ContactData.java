package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String homephone;
    private final String email;
    private String group;

    public ContactData(int id, String firstname, String middlename, String lastname, String homephone, String email, String group) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.homephone = homephone;
        this.email = email;
        this.group = group;
    }

    public ContactData(String firstname, String middlename, String lastname, String homephone, String email, String group) {
        this.id = 0;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.homephone = homephone;
        this.email = email;
        this.group = group;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getMiddleName() {
        return middlename;
    }

    public String getLastName() {
        return lastname;
    }

    public String getHomePhone() {
        return homephone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
