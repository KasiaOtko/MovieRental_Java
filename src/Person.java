public class Person {
    private String name;
    private String surname;
    private String telNumber;
    private String mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Person() {
        name = "";
        surname = "";
        telNumber = "";
        mail = "";
    }

    public Person(String name, String surname, String telNumber, String mail) {
        this.name = name;
        this.surname = surname;
        this.telNumber = telNumber;
        this.mail = mail;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + telNumber + " " + mail;
    }
}