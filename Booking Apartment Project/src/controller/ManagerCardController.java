package controller;

import service.CardService;

import static database.Database.*;
public class ManagerCardController {
    CardService cardService = new CardService();
    String menu = """
            0 - Exit
            1 - Show Balance
            2 - Deposite
            3 - show card history
            """;
    public void managerCardControl(){
        while (true){
            System.out.println(menu);
            switch (intScanner.nextInt()){
                case 0 -> {return;}
                case 1 ->{cardService.showManagerBalance();}
                case 2 ->{cardService.managerDeposite();}
                case 3 ->{cardService.showManagerHistory();}
                default -> System.out.println("Wrong option");
            }
        }
    }
}
