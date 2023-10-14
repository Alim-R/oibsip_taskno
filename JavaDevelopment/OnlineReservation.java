import java.util.Scanner;
public class OnlineReservation {
    private static boolean[] seats = new boolean[10];
    private static boolean loggedIn = false;

    private static final String USERNAME = "user1";
    private static final String PASSWORD = "password1";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Reservation System");
        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();
        
        if (login(enteredUsername, enteredPassword)) {
            loggedIn = true;
            System.out.println("Login successful!\n");
        } else {
            System.out.println("Login failed. Exiting...");
            System.exit(1);
        }

        while (true) {
            System.out.println("1. Reserve Seat");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Exit");
            System.out.println("Please select an option:");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                reserveSeat();
                break;

                case 2:
                cancelReservation();
                break;

                case 3:
                System.exit(0);

                default:
                System.out.println("Invalid option!");

            }
        }
    }

    private static boolean login(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    private static void reserveSeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        }
        else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true; // reserve the seat
            System.out.println("Seat reserved!");
        }
    }

    private static void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-10): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat not reserved!");
        } else {
            seats[seatNumber - 1] = false; // unneserve the seat
            System.out.println("Reservation canceled!");
        }
    }
}
