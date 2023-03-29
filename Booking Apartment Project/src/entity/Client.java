package entity;

public class Client {
    private String ID;
    private String login;
    private String loginPassword;
    private Passport passport;
    private Card card;
    private Flat flat;
    private Boolean booked = false;
    // booked parametri hech qanday uyni ijaraga olganmi yoqmi bildiradi, Masalan: true = uyni ijaraga olgan, false = haligacham uyni ijaraga olmadi
    public Client() {}

    public Client(String ID, String login, String loginPassword, Passport passport, Card card, Flat flat, Boolean booked) {
        this.ID = ID;
        this.login = login;
        this.loginPassword = loginPassword;
        this.passport = passport;
        this.card = card;
        this.flat = flat;
        this.booked = booked;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {

        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public Boolean getBooked() {
        return booked;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }
}
