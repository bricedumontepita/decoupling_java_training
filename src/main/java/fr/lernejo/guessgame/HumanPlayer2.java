
package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer2 implements Player {
    private static final Logger logger = LoggerFactory.getLogger("player");

    public long askNextGuess() {
        long value = new Scanner(System.in).nextLong();
        return value;
    }

    /**
     * Called by {@link Simulation} to inform that the previous guess was lower or greater that the number to find.
     */
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            this.logger.log("Plus grand");
        else
            this.logger.log("Plus petit");
    }
}
