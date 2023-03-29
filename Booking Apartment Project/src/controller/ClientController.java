package controller;

import service.CardService;
import service.ClientService;

import static database.Database.*;
public class ClientController {

    ClientService clientService = new ClientService();
    CardService cardService = new CardService();
    ClientCardController clientCardController = new ClientCardController();
    private String menu = """
           0 - Exit
           1 - Rent a flat
           2 - Card info
           3 - Cancel booked apartment
           4 - Delete account
           5 - See current Flat
            """;

    public void clientControl(){
        while(true){
            System.out.println(menu);
            switch (intScanner.nextInt()){
                case 0 -> {
                    return;
                }
                case 1 -> {
                    if (clientService.rentFlat()) {
                        System.out.println("Successfully rented flat");
                    }
                }
                case 2 ->{
                    if (cardService.checkClientCard()){
                        clientCardController.clientCardControl();
                    }
                }
                case 3 ->{
                    clientService.cancelBookedApartment();
                }
                case 4 ->{
                    if (clientService.deleteAccount()){
                        return;
                    }
                }
                case 5 -> {
                    clientService.showFlatInfo();
                }
            }
        }
    }
}
