package service;

import java.util.Scanner;
import util.Util;

public class TwoPlayer extends Player {

    public static int correctGuesses1 = 0;
    public static int correctGuesses2 = 0;

    private String name1;
    private String name2;

    public TwoPlayer(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's play " + name1 + " & " + name2 + " !(-1 to exit)");
        int totalGuess = 0;

        while (true) {
            int dice = diceNumber();
            System.out.print(name1 + ". Guess a dice number: ");
            int guess1 = scanner.nextInt();
            scanner.nextLine();
            System.out.print(name2 + ". Guess a dice number: ");
            int guess2 = scanner.nextInt();
            scanner.nextLine();
            boolean player1 = guess1 == dice;
            boolean player2 = guess2 == dice;

            if (guess1 == -1 || guess2 == -1) {
                System.out.println("Total guess: " + totalGuess);
                Util.showScore(name1, correctGuesses1);
                Util.showScore(name2, correctGuesses2);
                System.out.println("--------------------");
                break;
            }
            if (player1) {
                correctGuesses1++;
                System.out.println(name1 + " :  CORRECT!");

                Util.showScore(name1, correctGuesses1);
            }
            if (player2) {
                correctGuesses2++;
                System.out.println(name2 + " : CORRECT!");

                Util.showScore(name2, correctGuesses2);
            }
            System.out.println("Dice number was : " + dice);
            totalGuess++;
        }

    }

}
