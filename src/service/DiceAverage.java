package service;

import java.util.Random;
import java.util.Scanner;

public class DiceAverage {

    public static double average = 0;
    public static double sum = 0.0;
    public static int count = 0;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void playMultipleTimes(int n) {
        for (int i = 0; i < n; i++) {
            count++;
            double d = diceAverage();
            sum += d;
        }

    }

    public static void playSum() {
        while (true) {
            System.out.print("press enter: ");
            String s = scanner.nextLine();
            if (s.equals("-1")) {
                System.out.println("Game finished...");
                break;
            }
            count++;
            double d = diceAverage();
            sum += d;
            System.out.println(d);

        }
    }

    public static void playInfinity() {
        while (true) {
            count++;
            double d = diceAverage();
            sum += d;
            if (findAverage() == 3.500) {
                break;
            }
        }
        System.out.print("Count: " + count + "\n");

    }

    public static double diceAverage() {
        double n = 0;
        for (int i = 0; i < 6; i++) {
            int dice = 1 + random.nextInt(6);
            n += dice;
        }
        double d = n / 6;
        double roundOff = roundDown(d, 10);
        return roundOff;
    }

    public static double roundDown(double d, int decimal) {
        d *= decimal;
        d = Math.round(d);
        d /= decimal;
        return d;
    }

    public static double findAverage() {
        average = sum / count;
        average = roundDown(average, 1000);
        return average;
    }

    public static void reset() {
        average = 0;
        count = 0;
        sum = 0;
    }

}
