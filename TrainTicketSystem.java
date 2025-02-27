import java.util.*;

public class TrainTicketSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Train Ticket Booking System ---");
            System.out.println("1. Ticket Booking");
            System.out.println("2. Ticket Updation & Cancellation");
            System.out.println("3. Admin Panel");
            System.out.println("4. Ticket & Train Live Status");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    ticketBooking();
                    break;
                case 2:
                    System.out.println("Ticket Updation & Cancellation - Feature under development.");
                    break;
                case 3:
                    System.out.println("Admin Panel - Feature under development.");
                    break;
                case 4:
                    System.out.println("Ticket & Train Live Status - Feature under development.");
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void ticketBooking() {
        if (authenticateUser()) {
            showJourneyOptions();
        } else {
            System.out.println("Authentication failed. Returning to main menu.\n");
        }
    }

    static boolean authenticateUser() {
        System.out.print("\nEnter User ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        return userId.equals("user123") && password.equals("pass123");
    }

    static void showJourneyOptions() {
        System.out.println("\n--- Available Popular Journeys ---");
        String[] journeys = {
                "New Delhi to Mumbai",
                "Chennai to Bengaluru",
                "Kolkata to Hyderabad",
                "Jaipur to Agra",
                "Pune to Goa"
        };
        for (int i = 0; i < journeys.length; i++) {
            System.out.println((i + 1) + ". " + journeys[i]);
        }
        System.out.print("Select a journey (1-5): ");
        int option = sc.nextInt();
        sc.nextLine();

        if (option >= 1 && option <= 5) {
            processTicket(journeys[option - 1]);
        } else {
            System.out.println("Invalid selection. Returning to main menu.");
        }
    }

    static void processTicket(String journey) {
        System.out.println("\nProcessing your booking for: " + journey + "...");
        try {
            Thread.sleep(2000);  // Simulate processing delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String pnr = generatePNR();
        System.out.println("\n✅ Ticket Confirmed!");
        System.out.println("PNR Number : " + pnr);
        System.out.println("Journey    : " + journey);
        System.out.println("Status     : Confirmed ✔\n");
    }

    static String generatePNR() {
        return "PNR" + (int) (Math.random() * 9000 + 1000);
    }
}
