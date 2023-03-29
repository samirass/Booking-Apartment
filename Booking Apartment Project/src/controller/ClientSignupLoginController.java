package controller;

import service.ClientService;

import static database.Database.*;

public class ClientSignupLoginController {
    ClientService clientService = new ClientService();
    ClientController clientController = new ClientController();
    String menu = """
            0 - Exit
            1 - Login
            2 - Sign up
            """;

    public void loginAndSignupController() {
        while (true) {
            System.out.println(menu);
            switch (intScanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    if (clientService.checkClientLogin()) {
                        if (isRemoved && clientService.checkRemovedFlatClient()) {
                            clientService.removedFlat();
                        }
                        clientController.clientControl();
                    }
                }
                case 2 -> {
                    if (clientService.checkClientSignUp()) {
                        clientController.clientControl();
                    }
                }
            }
        }
    }
}
