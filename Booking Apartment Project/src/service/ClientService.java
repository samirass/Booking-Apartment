package service;

import entity.Card;
import entity.Client;
import entity.Flat;
import entity.Passport;

import static database.Database.*;

public class ClientService {
    public Boolean checkClientLogin() {
        System.out.printf("Enter your login: ");
        String login = strScanner.nextLine();
        System.out.printf("Enter your login password: ");
        String loginPassword = strScanner.nextLine();
        for (int i = 0; i < clientCounter; i++) {
            if (login.equals(clients[i].getLogin()) &&
                    loginPassword.equals(clients[i].getLoginPassword())) {
                currentClient = i;
                return true;
            }
        }
        System.out.println("wrong login or password");
        return false;
    }

    public Boolean checkClientSignUp() {
        if (clientCounter == 10) {
            System.out.println("you reached max amount of client accounts");
            return false;
        }
        Client client = new Client();
        Passport passport = new Passport();
        Card card = new Card();
        //Passport Info:
        System.out.print("Enter your name(Enter only letters): ");
        passport.setName(strScanner.nextLine());
        System.out.print("Enter your surname(Enter only letters): ");
        passport.setSurname(strScanner.nextLine());
        System.out.print("Enter your Birth Date: ");
        passport.setBirthDate(strScanner.nextLine());
        System.out.print("Enter your passport ID: ");
        passport.setPassportID(strScanner.nextLine());
        //Client Info:
        System.out.print("Enter your ID: ");
        client.setID(strScanner.nextLine());
        System.out.print("Enter your login: ");
        client.setLogin(strScanner.nextLine());
        System.out.print("Enter your login password:");
        client.setLoginPassword(strScanner.nextLine());
        //Card Info:
        System.out.print("Enter your card number(size: 16, only numbers): ");
        card.setCardNumber(strScanner.nextLine());
        System.out.print("Enter your card password(size: 4, only numbers): ");
        card.setCardPassword(strScanner.nextLine());
        System.out.print("Enter your balance: ");
        card.setBalance(intScanner.nextDouble());

        client.setPassport(passport);
        client.setCard(card);

        //checkClient
        if (client.getLogin().equals(manager.getLogin()) ||
                client.getPassport().getPassportID().equals(manager.getPassport().getPassportID()) ||
                client.getCard().getCardNumber().equals(manager.getCard().getCardNumber())) {
            System.out.println("Bunday account bor");
            return false;
        }
        for (int i = 0; i < clientCounter; i++) {
            if (clients[i].getPassport().getPassportID().equals(client.getPassport().getPassportID()) ||
                    clients[i].getCard().getCardNumber().equals(client.getCard().getCardNumber()) ||
                    clients[i].getLogin().equals(client.getLogin())
            ) {
                System.out.println("Bunday account bor");
                return false;
            }
        }
        clients[clientCounter] = client;
        currentClient = clientCounter++;
        System.out.println("Successfully signed up");
        return true;
    }

    public Boolean rentFlat() {
        if (clients[currentClient].getBooked()) {
            //agar client boshqa uyni ijaraga olgan bo`lsa -> return false;
            System.out.println("You already have rented flat");
            return false;
        }
        Flat flat = new Flat();
        System.out.println("Enter flat ID: ");
        flat.setFlatID(strScanner.nextLine());
        System.out.println("Enter how much do you want to stay in there(days): ");
        flat.setDays(intScanner.nextDouble());
        for (int i = 0; i < flatCounter; i++) {
            if (flat.getFlatID().equals(flats[i].getFlatID())) {
                if (flats[i].getBooked()) {
                    //agar uyni kimdir ijaraga olib bo`lgan bo`lsa -> return false;
                    System.out.println("This flat is already booked");
                    return false;
                }
                if (clients[currentClient].getCard().getBalance() >= flats[i].getPricePerDay() * flat.getDays()) {
                    System.out.println("This flat`s tariff is " + flats[i].getTariff());
                    System.out.println("This flat`s price per day is: " + flats[i].getPricePerDay());
                    System.out.println("In total it will be:" + flats[i].getPricePerDay() * flat.getDays() + "$");
                    System.out.println("Do you want to rent this flat");
                    System.out.println("1 - Yes");
                    System.out.println("0 - No");
                    switch (intScanner.nextInt()) {
                        case 1 -> {
                            currentFlat = i;
                            Double rentPrice = flats[currentFlat].getPricePerDay() * flat.getDays();
                            Card card1 = clients[currentClient].getCard();
                            Card card2 = manager.getCard();

                            card1.setBalance(card1.getBalance() - rentPrice);
                            card2.setBalance(card2.getBalance() + rentPrice);

                            flats[currentFlat].setBooked(true);
                            clients[currentClient].setBooked(true);
                            clients[currentClient].setFlat(flats[currentFlat]);

                            clients[currentClient].getFlat().setDays(flat.getDays());

                            System.out.println("Balance: " + card1.getBalance());

                            card1.setHistory(card2.getCardNumber() + " raqamli kartaga " + rentPrice + "$ otkazildi");
                            card2.setHistory(card1.getCardNumber() + " raqamli kartadan " + rentPrice + "$ keldi");

                            return true;
                        }
                        case 0 -> {
                            return false;
                        }
                    }
                } else {
                    System.out.println("You don`t have enough money");
                    return false;
                }
            }
        }
        System.out.println("There is no flat with this parameters");
        return false;
    }

    public Boolean deleteAccount() {
        if (clientCounter > 1) {
            if (clients[currentClient].getFlat() != null) {
                clients[currentClient].getFlat().setBooked(false);
            }
            System.out.print("Enter your account password to confirm deleting: ");
            String password = strScanner.nextLine();
            if (password.equals(clients[currentClient].getLoginPassword())) {

                clients[currentClient] = clients[clientCounter - 1];
                System.out.println("Account Deleted");
                clientCounter--;
                return true;
            }
        }
        System.out.println("You can't have less than 1 account");
        return false;
    }

    public void cancelBookedApartment() {
        if (clients[currentClient].getFlat() == null) {
            //agar clientda flat bo`lmasa default holatda u null bo`ladi, agar null bo`lsa return false;
            System.out.println("You didn`t have rented flat");
            return;
        }
        System.out.println("Enter how much did you stay there(days): ");
        int stayedDays = intScanner.nextInt();

        if (stayedDays > clients[currentClient].getFlat().getDays() || stayedDays < 0) {
            System.out.println("Wrong number occured");
            return;
        }
        Double pricePerDay = clients[currentClient].getFlat().getPricePerDay();
        Double rentPrice = clients[currentClient].getFlat().getPricePerDay() * clients[currentClient].getFlat().getDays();
        Card card1 = clients[currentClient].getCard();
        Card card2 = manager.getCard();
        //              boshlang'ich summaga + (ijara haqqi - kunlik ijara haqqi * necha kun qolgan)
        card1.setBalance(card1.getBalance() + (rentPrice - pricePerDay * stayedDays));

       //              boshlang'ich summadan - (ijara haqqi - kunlik ijara haqqi * necha kun qolgan)
        card2.setBalance(card2.getBalance() - (rentPrice - pricePerDay * stayedDays));

        card1.setHistory(card2.getCardNumber() + " raqamli kartadan " + (rentPrice - pricePerDay * stayedDays) + "$ keldi");
        card2.setHistory(card1.getCardNumber() + "ga " + ( rentPrice - pricePerDay * stayedDays )+ "$ otkazildi");

        clients[currentClient].getFlat().setBooked(false);
        clients[currentClient].setBooked(false);

        System.out.println("Successfully canceled booked apartment");
        System.out.println("Money returned: " + (rentPrice - pricePerDay * stayedDays));
    }

    public void showFlatInfo() {
        if ( clients[currentClient].getFlat() == null ||
                !clients[currentClient].getFlat().getBooked() ||
                !clients[currentClient].getBooked() ) {
            System.out.println("You have not booked any apartment");
        }
        else System.out.println(clients[currentClient].getFlat());
    }

    public void removedFlat() {
        System.out.println("your apartment has been removed, so we will return left money");
        System.out.println("Enter how much did you stay there(days): ");
        int stayedDays = intScanner.nextInt();

        if (stayedDays >= clients[currentClient].getFlat().getDays() || stayedDays < 0) {
            System.out.println("Wrong number occured");
            return;
        }
        Double pricePerDay = clients[currentClient].getFlat().getPricePerDay();
        Double rentPrice = blank.getPricePerDay() * blank.getDays();
        Card card1 = clients[currentClient].getCard();
        Card card2 = manager.getCard();

        //              boshlang'ich summaga + (ijara haqqi - kunlik ijara haqqi * necha kun qolgan)
        card1.setBalance(card1.getBalance() + (rentPrice - pricePerDay * stayedDays));

        //              boshlang'ich summadan - (ijara haqqi - kunlik ijara haqqi * necha kun qolgan)
        card2.setBalance(card2.getBalance() - (rentPrice - pricePerDay * stayedDays));

        card1.setHistory(card2.getCardNumber() + " raqamli kartadan " + (rentPrice - pricePerDay * stayedDays) + "$ keldi");
        card2.setHistory(card1.getCardNumber() + "ga " + (rentPrice - pricePerDay * stayedDays) + "$ otkazildi");
        clients[currentClient].setBooked(false);
        isRemoved = false;

        System.out.println("Money returned successfully");
        System.out.println("Money returned: " + (rentPrice - pricePerDay * stayedDays));
    }

    public boolean checkRemovedFlatClient() {
        //clients[0].getFlat() = flats[0]
        //blank = flats[0]
        return clients[currentClient].getFlat().equals(blank);
    }
}
