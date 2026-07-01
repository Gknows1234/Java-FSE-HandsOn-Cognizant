

public class Logger {
    
    private static Logger loggerObj;
    
    private Logger() {
    }
    
    public static Logger getInstance() {
        if (loggerObj == null) {
            loggerObj = new Logger();
        }
        return loggerObj;
    }
    
    public void printLog(String msg) {
        System.out.println("Log entry -> " + msg);
    }
}
