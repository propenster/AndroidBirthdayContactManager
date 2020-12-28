package com.github.propenster.birthdaycontactmanager.Models;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {
    private int Id;
    private String contactName;
    private String contactPhone;
    private Date contactBirthDate;

    public Contact(int id, String contactName, String contactPhone, Date contactBirthDate) {
        Id = id;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactBirthDate = contactBirthDate;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Id=" + Id +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactBirthDate=" + contactBirthDate +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getContactBirthDate() {
        return contactBirthDate;
    }

    public void setContactBirthDate(Date contactBirthDate) {
        this.contactBirthDate = contactBirthDate;
    }
}
