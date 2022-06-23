package company.log;

public class ConsoleLogger implements Logger{
    @Override
    public void info(String str) {
        System.out.println(str);
    }

    @Override
    public void error(String str, Exception e) {
        System.out.println(str + e.toString());
    }
}
