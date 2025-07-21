package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<String> bookingHistory;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.bookingHistory = new ArrayList<>();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public List<String> getBookingHistory() { return bookingHistory; }

    public void addBooking(String booking) {
        bookingHistory.add(booking);
    }

    public String toFileString() {
        return username + "," + password + "," + String.join("|", bookingHistory);
    }

    public static User fromFileString(String line) {
        String[] parts = line.split(",", 3);
        User user = new User(parts[0], parts[1]);
        if (parts.length == 3) {
            String[] history = parts[2].split("\\|");
            for (String h : history) {
                user.addBooking(h);
            }
        }
        return user;
    }
}
