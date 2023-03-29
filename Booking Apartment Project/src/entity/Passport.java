package entity;

public class Passport {
    private String name;
    private String surname;
    private String birthDate;
    private String passportID;

    public Passport() {
    }

    public Passport(String name, String surname, String birthDate, String passportID) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.passportID = passportID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
    if (name.matches("[a-zA-Z]"))
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname.matches("[a-zA-Z]"))
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }
}
