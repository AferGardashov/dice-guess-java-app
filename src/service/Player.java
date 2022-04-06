
package service;

import java.util.Random;

public abstract class Player {

    public abstract void play();

    public static int diceNumber() {
        Random random = new Random();
        int number = 1 + random.nextInt(6);
        return number;
    }
}
