package jobapplicantlogger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggingService {

    private static Logger logger = Logger.getLogger(LoggingService.class);

    private LoggingService() {}

    public static void log(String message) {
        logger.log(Level.INFO, "Job-Application received: " + message);
    }

}
