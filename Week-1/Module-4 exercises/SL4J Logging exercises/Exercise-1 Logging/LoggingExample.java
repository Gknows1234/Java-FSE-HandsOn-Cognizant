import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger appLog = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        String errTxt = "This is an error message";
        String warnTxt = "This is a warning message";
        
        appLog.error(errTxt);
        appLog.warn(warnTxt);
    }
}
