package fr.lernejo.logger;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ContextualLogger implements Logger {
    private String name;
    private Logger logger;

    public ContextualLogger(String name, Logger logger) {
        this.name = name;
        this.logger = logger;
    }

    public void log(String message) {
        String date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(
            new Date(System.currentTimeMillis())
        );
        this.logger.log(date + " " + this.name + " " + message);
    }
}
