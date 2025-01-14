package model;

public record ContactData(String id, String name1, String name2, String photo) {


    public ContactData() {
        this("", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.name1, this.name2, this.photo);
    }

    public ContactData withFirstName(String name) {
        return new ContactData(this.id, name, this.name2, this.photo);
    }

    public ContactData withSecondName(String name) {
        return new ContactData(this.id, this.name1, name, this.photo);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.name1, this.name2, photo);
    }
}