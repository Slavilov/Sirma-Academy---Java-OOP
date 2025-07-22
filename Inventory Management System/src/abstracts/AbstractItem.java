package abstracts;

import interfaces.*;

public abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {
    public String name;
    protected String category;
    protected double price;
    protected boolean breakable;
    protected boolean perishable;

    public AbstractItem(String name, String category, double price, boolean breakable, boolean perishable) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.breakable = breakable;
        this.perishable = perishable;
    }

    public String getDetails() {
        return "Name: " + name + ", Category: " + category + ", Price: " + price;
    }

    public void displayDescription() {
        System.out.println(getDetails());
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBreakable() {
        return breakable;
    }

    public void handleBreakage() {
        if (breakable) {
            System.out.println(name + " is broken.");
        }
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void handleExpiration() {
        if (perishable) {
            System.out.println(name + " has expired.");
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}