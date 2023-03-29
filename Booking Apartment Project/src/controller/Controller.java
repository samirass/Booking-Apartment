package controller;

import service.ManagerService;

import static database.Database.*;

public class Controller {

    ClientSignupLoginController controller = new ClientSignupLoginController();
    ManagerService managerService = new ManagerService();
    ManagerController managerController = new ManagerController();
    String mainMenu = """
            0 - Exit
            Enter as:
            1 - Client
            2 - Manager
            """;
    public void mainController(){
        while(true){
            System.out.println(mainMenu);
            switch (intScanner.nextInt()){
                case 0 ->{
                    System.out.println("Good Bye");
                    return;
                }
                case 1 ->{
                    controller.loginAndSignupController();
                }
                case 2->{
                    if (managerService.checkManagerLogin()){
                        managerController.managerControl();
                    }
                }
                default -> {
                    System.out.println("wrong option");
                }
            }
        }
    }
}
