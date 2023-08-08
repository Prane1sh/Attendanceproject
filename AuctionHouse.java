package project;

import java.util.List;

public class AuctionHouse {
    private DatabaseHandler databaseHandler;
    private User loggedInUser;

    public AuctionHouse() {
        databaseHandler = new DatabaseHandler();
    }

    public void registerUser(String username, String password) {
        databaseHandler.addUser(username, password);
    }

    public User authenticateUser(String username, String password) {
        return databaseHandler.authenticateUser(username, password);
    }

    public void listItem(String name, String description, double startingBid) {
        if (loggedInUser == null) {
            System.out.println("Please log in first to list an item.");
        } else {
            databaseHandler.addItem(name, description, startingBid);
            System.out.println("Item listed successfully!");
        }
    }

    public List<Item> getAllItems() {
        return databaseHandler.getAllItems();
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void bidItem(int itemId, double newBid, int bidderId) {
        // Fetch the current item from the database
        List<Item> items = databaseHandler.getAllItems();
        Item currentItem = null;
        for (Item item : items) {
            if (item.getId() == itemId) {
                currentItem = item;
                break;
            }
        }

        if (currentItem == null) {
            System.out.println("Item with ID " + itemId + " not found.");
            return;
        }

        // Check if the new bid is higher than the current bid
        if (newBid > currentItem.getCurrentBid()) {
            // Update the current bid and highest bidder ID in the database
            databaseHandler.updateItemBid(itemId, newBid, bidderId);
            currentItem.setCurrentBid(newBid);
            currentItem.setHighestBidderId(bidderId);
            System.out.println("Bid successful! Current bid for item " + itemId + " is now: " + newBid);
        } else {
            System.out.println("Your bid is not higher than the current bid. Please try again with a higher bid.");
        }
    }
}
