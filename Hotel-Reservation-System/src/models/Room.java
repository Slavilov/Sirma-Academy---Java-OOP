package models;

public class Room {
    private String number;
    private String type;
    private double price;
    private double cancellationFee;
    private boolean booked;

    public Room(String number, String type, double price, double cancellationFee, boolean booked) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.cancellationFee = cancellationFee;
        this.booked = booked;
    }

    public String getNumber() { return number; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public double getCancellationFee() { return cancellationFee; }
    public boolean isBooked() { return booked; }

    public void setBooked(boolean booked) { this.booked = booked; }

    @Override
    public String toString() {
        return "Room " + number + " [" + type + "] - $" + price + " - " + (booked ? "Booked" : "Available");
    }

    public String toFileString() {
        return number + "," + type + "," + price + "," + cancellationFee + "," + booked;
    }

    public static Room fromFileString(String line) {
        String[] parts = line.split(",");
        return new Room(parts[0], parts[1], Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3]), Boolean.parseBoolean(parts[4]));
    }
}
