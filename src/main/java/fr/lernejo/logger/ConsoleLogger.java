package fr.lernejo.logger;

import fr.lernejo.logger.Logger;

public class ConsoleLogger implements Logger {
    public void log (String message) {
        System.out.println(message);
    }
}
