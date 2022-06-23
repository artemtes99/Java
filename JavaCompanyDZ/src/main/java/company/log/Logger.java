package company.log;

public interface Logger {

    void info(String str);

    void error(String str, Exception e);
}
