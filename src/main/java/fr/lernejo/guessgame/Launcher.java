package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        HumanPlayer2 player = new HumanPlayer2();
        Simulation simulation = new Simulation (player);
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
        simulation.initialize(randomNumber);
        simulation.loopUntilPlayerSucceed();
    }
}
