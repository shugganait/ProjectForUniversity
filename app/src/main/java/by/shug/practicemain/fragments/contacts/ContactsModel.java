package by.shug.practicemain.fragments.contacts;

public class ContactsModel {
    private String number;
    private String name;
    private String status;

    public ContactsModel(String name, String description, String number) {
        this.name = name;
        this.number = number;
        this.status = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
