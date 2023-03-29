package database;

import entity.*;

import java.util.Scanner;

public class Database {
    public static Scanner intScanner = new Scanner(System.in);
    public static Scanner strScanner = new Scanner(System.in);

    public static int currentClient = 0;
    public static int currentFlat = 0;
    public static int clientCounter = 1;
    public static int flatCounter = 1;


    public static Boolean isRemoved = false;
    public static Flat blank;

    public static Manager manager = new Manager("1", "ssamiras_", "dmnv",
            new Passport("samira", "daminova", "", "7777"),
            new Card("1234123412341234", "1234", 100000d));
    public static Client[] clients = new Client[10];
    public static Flat[] flats = new Flat[10];

    static {
        Flat flat = new Flat("", "", "", "", 0d, 0d, "", 0d, true);
        flats[0] = flat;
        currentFlat = 0;
        Client client = new Client("", "", "",
                new Passport("", "", "", ""),
                new Card("", "", 10000d),
                flat, true);
        clients[0] = client;
        currentClient = 0;
    }
}
