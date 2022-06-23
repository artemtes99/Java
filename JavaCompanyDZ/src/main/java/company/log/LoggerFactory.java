package company.log;

public class LoggerFactory {
    public static Logger getLogger() {
        return new ConsoleLogger();
    }
}
