package service;

import entity.Flat;

import static database.Database.*;

public class ManagerService {
    public Boolean checkManagerLogin() {
        System.out.println("Enter your login");
        String login = strScanner.nextLine();
        System.out.println("Enter your login password");
        String loginPassword = strScanner.nextLine();
        if (login.equals(manager.getLogin()) && loginPassword.equals(manager.getLoginPassword())) {
            System.out.println("Successfully entered");
            return true;
        }
        return false;
    }

    public void addFlat() {
        if (flatCounter == 10){
            System.out.println("You reached max amount of flats");
            return;
        }
        Flat flat = new Flat();
        Double recommendedPrice = 0.0d;
        System.out.println("Enter flat country: ");
        flat.setCountry(strScanner.nextLine());
        System.out.println("Enter flat city: ");
        flat.setCity(strScanner.nextLine());
        System.out.println("Enter flat address: ");
        flat.setAddress(strScanner.nextLine());
        System.out.println("Enter flat ID: ");
        flat.setFlatID(strScanner.nextLine());
        System.out.println("Enter flat area in m^2: ");
        flat.setArea(intScanner.nextDouble());
        recommendedPrice += flat.getArea();
        System.out.println("""
                Choose flat tariff:
                1 - Good
                2 - Very good
                3 - Amazing
                """);
        switch (intScanner.nextInt()) {
            case 1 -> {
                flat.setTariff("Good");
                recommendedPrice += 200d;
            }
            case 2 -> {
                flat.setTariff("Very good");
                recommendedPrice += 300d;
            }
            case 3 -> {
                flat.setTariff("Amazing");
                recommendedPrice += 500d;
            }
            default -> {
                System.out.println("Wrong option");
                return;
            }
        }
        System.out.println("Choose price per day(recommended: " + Math.round(recommendedPrice / 7) + "$): ");
        flat.setPricePerDay(intScanner.nextDouble());
        for (int i = 0; i < flatCounter; i++) {
            if (flat.getAddress().equals(flats[i].getAddress()) ||
                    flat.getFlatID().equals(flats[i].getFlatID())) {
                //boshqa flatlarda bunday parametrlar bormi yoqmi tekshirvommiz
                System.out.println("You already have this flat");
                return;
            }
        }
        flat.setBooked(false); //bu kvartirani hozir hech kim ijaraga olgani yoq
        flats[flatCounter] = flat;
        currentFlat = flatCounter++;
        System.out.println("Successfully added new apartment");
    }

    public void removeFlat() {
        if (flatCounter < 1) {
            System.out.println("You can't have less than 1 flat");
            return;
        }
        System.out.println("Enter flat id to remove flat:");
        String flatID = strScanner.nextLine();
        for (int i = 0; i < flatCounter; i++) {
            if (flatID.equals(flats[i].getFlatID())) {
                blank = flats[i];
                flats[i] = flats[flatCounter - 1];
                System.out.println("Flat deleted");
                flatCounter--;
                isRemoved = true;
                return;
            }
        }
        System.out.println("Wrong flat ID");
    }

    public void changePassword() {
        System.out.println("Enter previous password: ");
        String previousPassword = strScanner.nextLine();
        if (!previousPassword.equals(manager.getLoginPassword())) {
            System.out.println("Wrong password");
            return;
        }
        System.out.println("Enter new password: ");
        String newPassword = strScanner.nextLine();
        if (newPassword.equals(previousPassword)) {
            System.err.println("New password can`t be like previous password");
            return;
        }
        manager.setLoginPassword(newPassword);
        System.out.println("Successfully changed password");
    }
}
