package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("Launcher");

        if (args.length >= 1 && args[0].equals("-interactive")){
            HumanPlayer2 player = new HumanPlayer2();
            Simulation simulation = new Simulation (player);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } else if (args.length >= 2 && args[0].equals("-auto")) {
            Scanner sc = new Scanner(args[1].trim());
            long arg2 = 0;
            if(sc.hasNextInt(10)) {
                arg2 = sc.nextInt(10);
                ComputerPlayer player = new ComputerPlayer();
                Simulation simulation = new Simulation (player);
                simulation.initialize(arg2);
                simulation.loopUntilPlayerSucceed(1000);
            } else {
                logger.log("Usage: programme -auto nomber");
            }
        } else {
            logger.log("Usage: programme -auto nomber ou programme -interactive");
        }
    }
}
