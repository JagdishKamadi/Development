package org.example;
import org.apache.logging.log4j.*;


public class App 
{
    private static final Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        logger.debug("Debug Level");
        logger.info("Info Level");
        logger.warn("Warn Level");
        logger.error("Error Level");
        logger.fatal("Fatal Level");

    }
}
