import java.util.Scanner;

public class MovieTheater {

    char[][] seats = new char[5][10]; // Seating chart with 5 rows and 10 seats per row

    public MovieTheater() {
        // Initialize all seats to 'A' (Available)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                seats[i][j] = 'A';
            }
        }
    }

    public void showSeats() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < 10; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void reserveSeat(int row, int seat) {
        if (row >= 0 && row < 5 && seat >= 0 && seat < 10) {
            if (seats[row][seat] == 'A') {
                seats[row][seat] = 'R';
                System.out.println("Seat reserved successfully.");
            } else {
                System.out.println("Seat is already reserved.");
            }
        } else {
            System.out.println("Invalid seat selection.");
        }
    }

    public void cancelSeat(int row, int seat) {
        if (row >= 0 && row < 5 && seat >= 0 && seat < 10) {
            if (seats[row][seat] == 'R') {
                seats[row][seat] = 'A';
                System.out.println("Reservation canceled successfully.");
            } else {
                System.out.println("Seat is not reserved.");
            }
        } else {
            System.out.println("Invalid seat selection.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieTheater theater = new MovieTheater();

        while (true) {
            System.out.println("\nMovie Theater System");
            System.out.println("1. Show seats");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                theater.showSeats();
            } else if (choice == 2) {
                System.out.print("Enter row (0-4): ");
                int row = scanner.nextInt();
                System.out.print("Enter seat (0-9): ");
                int seat = scanner.nextInt();
                theater.reserveSeat(row, seat);
            } else if (choice == 3) {
                System.out.print("Enter row (0-4): ");
                int row = scanner.nextInt();
                System.out.print("Enter seat (0-9): ");
                int seat = scanner.nextInt();
                theater.cancelSeat(row, seat);
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
