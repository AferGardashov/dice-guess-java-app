package service;

import java.util.Scanner;
import util.Util;

public class OnePlayer extends Player {

    public static int correctGuesses = 0;
    private String name;

    public OnePlayer(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play " + name + " !(-1 to exit)");
        int totalGuess = 0;
        while (true) {
            int dice = diceNumber();
            System.out.print("Guess a dice number: ");
            int guess = scanner.nextInt();
            scanner.nextLine();
            if (guess == -1) {
                System.out.println("Total guess: " + totalGuess);
                Util.showScore(name, correctGuesses);
                System.out.println("--------------------");
                break;
            }
            if (guess == dice) {
                System.out.println("Correct!");
                correctGuesses++;
                Util.showScore(name, correctGuesses);

            } else {
                System.out.println("Wrong!");
                System.out.println("Dice number was : " + dice);
            }
            totalGuess++;

        }
    }

    

}
