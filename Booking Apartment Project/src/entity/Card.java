package entity;

import java.util.ArrayList;

public class Card {
    private String cardNumber;
    private String cardPassword;
    private Double balance;
    private ArrayList<String> history = new ArrayList<>();
    //kartaning istoriyasini korib ketish uchun kerak

    public Card() {
    }

    public Card(String cardNumber, String cardPassword, Double balance) {
        this.cardNumber = cardNumber;
        this.cardPassword = cardPassword;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        //16 length, numbers
        if(cardNumber.matches("[0-9]{16}"))
        this.cardNumber = cardNumber;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public void setCardPassword(String cardPassword) {
        //4 length, numbers
        if (cardPassword.matches("[0-9]{4}"))
        this.cardPassword = cardPassword;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        if (balance > 0)
        this.balance = balance;
    }

    public void getHistory() {
        for (String s : history) {
            System.out.println(s);
        }
    }

    public void setHistory(String str) {
        history.add(str);
    }
}
