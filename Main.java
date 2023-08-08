package project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuctionHouse auctionHouse = new AuctionHouse();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Auction House!");

        while (true) {
            System.out.println("1. Register new user");
            System.out.println("2. Login");
            System.out.println("3. List a new item");
            System.out.println("4. Show all items");
            System.out.println("5. Bid an item");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    auctionHouse.registerUser(newUsername, newPassword);
                    System.out.println("User registered successfully!");
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    User loggedInUser = auctionHouse.authenticateUser(username, password);
                    if (loggedInUser != null) {
                        System.out.println("Login successful! Welcome, " + loggedInUser.getUsername());
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                    break;
                case 3:
                    if (auctionHouse.getLoggedInUser() == null) {
                        System.out.println("Please log in first to list an item.");
                    } else {
                        System.out.print("Enter item name: ");
                        String itemName = scanner.nextLine();
                        System.out.print("Enter item description: ");
                        String itemDescription = scanner.nextLine();
                        System.out.print("Enter starting bid: ");
                        double startingBid = scanner.nextDouble();
                        auctionHouse.listItem(itemName, itemDescription, startingBid);
                        System.out.println("Item listed successfully!");
                    }
                    break;
                case 4:
                    auctionHouse.getAllItems();
                    break;
                case 5:
                    if (auctionHouse.getLoggedInUser() == null) {
                        System.out.println("Please log in first to bid an item.");
                    } else {
                        System.out.print("Enter item ID to bid: ");
                        int itemId = scanner.nextInt();
                        System.out.print("Enter your bid: ");
                        double newBid = scanner.nextDouble();
                        int bidderId = auctionHouse.getLoggedInUser().getId();
                        auctionHouse.bidItem(itemId, newBid, bidderId);
                    }
                    break;
                case 0:
                    System.out.println("Thank you for using the Online Auction House. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
