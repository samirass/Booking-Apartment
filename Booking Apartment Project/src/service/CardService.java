package service;

import entity.Card;
import static database.Database.*;
public class CardService {
    public Boolean checkClientCard(){
        Card card = new Card();
        System.out.println("Enter your card number: ");
        card.setCardNumber(strScanner.nextLine());
        System.out.println("Enter your card password");
        card.setCardPassword(strScanner.nextLine());
        for (int i = 0; i < clientCounter; i++) {
            if(card.getCardNumber().equals(clients[currentClient].getCard().getCardNumber()) &&
            card.getCardPassword().equals(clients[currentClient].getCard().getCardPassword())){
                System.out.println("Successfully entered: ");
                return true;
            }
        }
        System.out.println("Wrong card number or card password");
        return false;
    }
    public void clientDeposite() {
        System.out.println("qancha mablag' kiritasiz");
        Double income = intScanner.nextDouble();
        if (income < 0) {
            System.err.println("Wrong number occured");
            return;
        }
        Card card = clients[currentClient].getCard();
        card.setBalance(card.getBalance() + income);
        System.out.println("Your balance: " + card.getBalance());
    }

    public void showClientBalance() {
        System.out. println("Balance: " + clients[currentClient].getCard().getBalance());
    }

    public Boolean checkManagerCard(){
        Card card = new Card();
        System.out.println("Enter your card number: ");
        card.setCardNumber(strScanner.nextLine());
        System.out.println("Enter your card password");
        card.setCardPassword(strScanner.nextLine());
        if(card.getCardNumber().equals(manager.getCard().getCardNumber()) &&
                    card.getCardPassword().equals(manager.getCard().getCardPassword())){
                System.out.println("Successfully entered: ");
                return true;
        }
        System.out.println("Wrong card number or card password");
        return false;
    }
    public void showManagerBalance() {
        System.out.println("Balance: " + manager.getCard().getBalance());
    }

    public void managerDeposite(){
        System.out.println("qancha mablag' kiritasiz");
        Double income = intScanner.nextDouble();
        if (income < 0) {
            System.err.println("Wrong number occured");
            return;
        }
        Card card = manager.getCard();
        card.setBalance(card.getBalance() + income);
        System.out.println("Your balance: " + card.getBalance());
    }

    public void showClientHistory() {
        clients[currentClient].getCard().getHistory();
    }
    public void showManagerHistory() {
        manager.getCard().getHistory();
    }
}
