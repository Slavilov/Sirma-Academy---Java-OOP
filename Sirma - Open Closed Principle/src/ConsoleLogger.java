public class ConsoleLogger implements LogStrategy {
    public void log(String message) {
        System.out.println(message);
    }
}
