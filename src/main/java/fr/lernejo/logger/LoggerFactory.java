package fr.lernejo.logger;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.ConsoleLogger;

public class LoggerFactory
{
    public static Logger getLogger(String name)
    {
        return new ContextualLogger(name, new CompositeLogger( new FileLogger("toto.txt"), new ConsoleLogger()));
    }
}
