



public class SingletonTest {
    public static void main(String[] args) {
        Logger firstLogger = Logger.getInstance();
        Logger secondLogger = Logger.getInstance();

        if (firstLogger == secondLogger) {
            System.out.println("Both objects point to the same instance.");
        } else {
            System.out.println("Different instances created!");
        }

        firstLogger.printLog("User clicked login");
        secondLogger.printLog("Database connected");
    }
}
