import java.util.*;

class UserAuthentication {
    static Scanner sc = new Scanner(System.in);

    static boolean authenticateUser() {
        System.out.print("\nEnter User ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        return userId.equals("user123") && password.equals("pass123");
    }
}

class TicketBooking {
    static Scanner sc = new Scanner(System.in);
    static String bookedPNR = null;
    static String bookedJourney = null;
    static String seatNo = "A1-23";
    static String coachNo = "S3";

    static void bookTicket() {
        if (UserAuthentication.authenticateUser()) {
            showJourneyOptions();
        } else {
            System.out.println("Authentication failed. Returning to main menu.\n");
        }
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bookedPNR = generatePNR();
        bookedJourney = journey;
        System.out.println("\n Ticket Confirmed!");
        System.out.println("PNR Number : " + bookedPNR);
        System.out.println("Journey    : " + bookedJourney);
        System.out.println("Seat No    : " + seatNo);
        System.out.println("Coach No   : " + coachNo);
        System.out.println("Status     : Confirmed ✔\n");
    }

    static String generatePNR() {
        return "PNR" + (int) (Math.random() * 9000 + 1000);
    }
}

class TicketManagement {
    static void updateOrCancelTicket() {
        if (TicketBooking.bookedPNR == null) {
            System.out.println("No ticket booked yet. Please book a ticket first.");
            return;
        }
        System.out.println("\nTicket Found!");
        System.out.println("PNR Number : " + TicketBooking.bookedPNR);
        System.out.println("Journey    : " + TicketBooking.bookedJourney);
        System.out.println("Seat No    : " + TicketBooking.seatNo);
        System.out.println("Coach No   : " + TicketBooking.coachNo);

        System.out.println("\nChoose an option:");
        System.out.println("1. Update Ticket");
        System.out.println("2. Cancel Ticket");
        System.out.print("Select an option: ");
        int option = TicketBooking.sc.nextInt();
        TicketBooking.sc.nextLine();

        switch (option) {
            case 1:
                updateTicket();
                break;
            case 2:
                cancelTicket();
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    static void updateTicket() {
        System.out.println("\n--- Ticket Update Options ---");
        System.out.println("1. Change Seat & Coach");
        System.out.println("2. Change Train (Same Route)");
        System.out.print("Select an option: ");
        int option = TicketBooking.sc.nextInt();
        TicketBooking.sc.nextLine();

        if (option == 1) {
            TicketBooking.seatNo = "A1-45";
            TicketBooking.coachNo = "S5";
            System.out.println("\n Seat and Coach updated successfully!");
        } else if (option == 2) {
            System.out.println("Train changed for the same route. Updated Successfully!");
        } else {
            System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    static void cancelTicket() {
        System.out.println("\n Ticket Cancelled Successfully!");
        TicketBooking.bookedPNR = null;
        TicketBooking.bookedJourney = null;
    }
}

class AdminPanel {
    static void showAdminPanel() {
        System.out.println("\n--- Admin Panel ---");
        if (TicketBooking.bookedPNR == null) {
            System.out.println("No tickets booked yet.");
        } else {
            System.out.println("PNR Number : " + TicketBooking.bookedPNR);
            System.out.println("Journey    : " + TicketBooking.bookedJourney);
            System.out.println("Seat No    : " + TicketBooking.seatNo);
            System.out.println("Coach No   : " + TicketBooking.coachNo);
            System.out.println("Status     : Confirmed");
        }
    }
}

class LiveTrainStatus {
    static void showLiveStatus() {
        System.out.println("\n--- Live Train Status ---");
        System.out.println("Train is currently On Time.");
    }
}

public class TrainTicketSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                    TicketBooking.bookTicket();
                    break;
                case 2:
                    TicketManagement.updateOrCancelTicket();
                    break;
                case 3:
                    AdminPanel.showAdminPanel();
                    break;
                case 4:
                    LiveTrainStatus.showLiveStatus();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
