package main;

import java.util.Scanner;
import util.Util;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        OUTER:
        while (true) {
            Util.showMenu();
            System.out.print("Choose a game: ");
            int oper = scanner.nextInt();
            scanner.nextLine();
            switch (oper) {
                case 1:
                    Util.singlePlayer();
                    break;
                case 2:
                    Util.twoPlayer();
                    break;
                case 3: 
                    Util.averageGame();
                    break;
                case -1:
                    System.out.println("Exiting...");
                    break OUTER;
                default:
                    System.out.println("Wrong operation, try again...");
                    break;
            }
        }

    }
}
