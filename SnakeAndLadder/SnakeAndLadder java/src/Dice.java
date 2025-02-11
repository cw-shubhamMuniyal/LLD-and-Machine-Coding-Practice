import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private final int diceCount;

    Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    int rollDice() {

        int count = 0, totalDiceValue = 0;

        while (count < diceCount) {
            totalDiceValue += ThreadLocalRandom.current().nextInt(1, 7);
            count++;
        }

        return totalDiceValue;
    }
}
