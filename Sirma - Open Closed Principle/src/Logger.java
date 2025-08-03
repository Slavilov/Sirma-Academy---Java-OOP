public class Logger {
    private LogStrategy strategy;

    public Logger(LogStrategy strategy) {
        this.strategy = strategy;
    }

    public void log(String message) {
        strategy.log(message);
    }
}
