package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class ComputerPlayer implements Player{
    private static final Logger logger = LoggerFactory.getLogger("computer");
    private boolean lowerOrGreater = true;
    private long min = 0;
    private long max = 100;
    private long current = -1;

    public long askNextGuess() {
        if (current == -1) {
            this.current = 50;
            this.logger.log(""+this.current);
            return 50;
        } else {
            if (lowerOrGreater == false) {
                this.max = this.current;
            } else {
                this.min = this.current;
            }
            this.current = (max + min) / 2;
            this.logger.log(""+this.current);
            return this.current;
        }
    }

    /**
     * Called by {@link Simulation} to inform that the previous guess was lower or greater that the number to find.
     */
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            this.logger.log("Plus grand");
        else
            this.logger.log("Plus petit");
        this.lowerOrGreater = lowerOrGreater;
    }
}
