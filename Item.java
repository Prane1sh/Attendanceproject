package project;

public class Item {
    private int id;
    private String name;
    private String description;
    private double startingBid;
    private double currentBid;
    private int highestBidderId;

    public Item(int id, String name, String description, double startingBid, double currentBid, int highestBidderId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startingBid = startingBid;
        this.currentBid = currentBid;
        this.highestBidderId = highestBidderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartingBid() {
        return startingBid;
    }

    public void setStartingBid(double startingBid) {
        this.startingBid = startingBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public int getHighestBidderId() {
        return highestBidderId;
    }

    public void setHighestBidderId(int highestBidderId) {
        this.highestBidderId = highestBidderId;
    }

    // Override toString() to get a formatted string representation of the item
    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", description=" + description + ", startingBid=" + startingBid
                + ", currentBid=" + currentBid + ", highestBidderId=" + highestBidderId + "]";
    }
}

