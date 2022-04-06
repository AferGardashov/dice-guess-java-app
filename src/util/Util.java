package util;

import java.util.Scanner;
import service.DiceAverage;
import service.OnePlayer;
import service.TwoPlayer;

public class Util {

    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        String menu = "-------MENU-------\n"
                 + "1. Single Player\n"
                 + "2. Two Players\n"
                 + "3. Dice average(3.5)\n"
                 + "-1. Exit";

        System.out.println(menu);

    }

    public static void showScore(String name, int guess) {

        System.out.println(name + "'s score: " + guess);
    }

    public static void singlePlayer() {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();

        OnePlayer one = new OnePlayer(name);
        one.play();
    }

    public static void twoPlayer() {
        System.out.print("Enter first player name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter second player name: ");
        String name2 = scanner.nextLine();

        TwoPlayer two = new TwoPlayer(name1, name2);
        two.play();
    }

    public static void averageGame() {
        while (true) {
            String msg = "\n1. Normal Dice game\n"
                     + "2. Multiple times by comp.\n"
                     + "3. Average Infinity(3.5)\n"
                     + "-1 to exit";
            System.out.println(msg);
            String input = scanner.nextLine();
            if (input.equals("1")) {
                DiceAverage.playSum();
                showAverage();

                //reset data
                DiceAverage.reset();
            } else if (input.equals("2")) {
                averageMultiple();
                showAverage();

                //reset data
                DiceAverage.reset();
            } else if (input.equals("3")) {
                DiceAverage.playInfinity();
                showAverage();

                //reset data
                DiceAverage.reset();
            } else if (input.equals("-1")) {
                break;
            } else {
                System.out.println("wrong input...");
            }

        }
    }

    public static void averageMultiple() {
        System.out.print("How many times to throw the dice? : ");
        int n = scanner.nextInt();
        scanner.nextLine();
        DiceAverage.playMultipleTimes(n);

    }

    public static void showAverage() {
        double d = DiceAverage.findAverage();
        System.out.println("Average is : " + d);
    }

}
