package controller;

import service.CardService;
import service.ManagerService;

import static database.Database.*;

public class ManagerController {
    ManagerService managerService = new ManagerService();
    CardService cardService = new CardService();
    ManagerCardController managerCardController = new ManagerCardController();
    private String menu = """
            0 - Exit
            1 - Add an apartment for rent
            2 - Remove an apartment for rent
            3 - Card info
            4 - Change my password
            """;

    public void managerControl() {
        while (true) {
            System.out.println(menu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    managerService.addFlat();
                }
                case 2 -> {
                    managerService.removeFlat();
                }
                case 3 -> {
                    if (cardService.checkManagerCard()) {
                        managerCardController.managerCardControl();
                    }
                }
                case 4 -> {
                    managerService.changePassword();
                }
                default -> System.out.println("wrong option");
            }
        }
    }
}
