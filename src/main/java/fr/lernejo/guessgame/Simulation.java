package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import fr.lernejo.guessgame.Player;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        logger.log("Entrez un nombre :");
        long number = this.player.askNextGuess();
        if (number == this.numberToGuess)
            return true;
        this.player.respond(number < this.numberToGuess);
        return false;
    }

    public void loopUntilPlayerSucceed() {
        boolean isRunning = true;
        int max = 10;
        int i = 0;
        while (isRunning && i < max)
        {
            isRunning = !this.nextRound();
            i++;
        }
    }
}
