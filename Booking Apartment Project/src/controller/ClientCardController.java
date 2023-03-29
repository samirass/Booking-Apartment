package controller;

import service.CardService;

import static database.Database.*;
public class ClientCardController {
    CardService cardService = new CardService();
    private String menu = """
            0 - Exit
            1 - show balance
            2 - deposite
            3 - show card history
            """;
    public void clientCardControl(){
        while (true){
            System.out.println(menu);
            switch (intScanner.nextInt()){
                case 0 -> {return;}
                case 1 ->{
                    cardService.showClientBalance();
                }
                case 2 ->{
                    cardService.clientDeposite();
                }
                case 3 ->{cardService.showClientHistory();}
                default -> System.out.println("Wrong option");
            }
        }
    }
}
