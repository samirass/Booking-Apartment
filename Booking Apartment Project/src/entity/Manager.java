package entity;

public class Manager {
    private String ID;
    private String login;
    private String loginPassword;
    private Card card;
    private Passport passport;

    public Manager() {
    }

    public Manager(String ID, String login, String loginPassword, Passport passport, Card card) {
        this.ID = ID;
        this.login = login;
        this.loginPassword = loginPassword;
        this.passport = passport;
        this.card = card;
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
