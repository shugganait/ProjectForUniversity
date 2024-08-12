package by.shug.practicemain.fragments.classes;

public class ClassesModel {
    private String number;
    private String description;

    public ClassesModel(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setnumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
