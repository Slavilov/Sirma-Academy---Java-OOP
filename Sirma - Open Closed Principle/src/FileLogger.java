public class FileLogger implements LogStrategy {
    private String filename;

    public FileLogger(String filename) {
        this.filename = filename;
    }

    public void log(String message) {
        System.out.println("Writing to " + filename + ": " + message);
    }
}
