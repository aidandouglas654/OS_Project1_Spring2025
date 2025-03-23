import java.util.*;

// Main class to run the scheduling algorithms
public class Main {
    public static void main(String[] args) {
        List<Process> processes = Arrays.asList(
            new Process(1, 0, 5, 2),
            new Process(2, 2, 3, 1),
            new Process(3, 4, 2, 3)
        );
        // User selction of the scheduling algorithm
        System.out.println("Choose Scheduling Algorithm:");
        System.out.println("1. First-Come, First-Served (FCFS)");
        System.out.println("2. Shortest Job First (SJF)");
        System.out.print("Enter choice: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                FCFSScheduler.schedule(new ArrayList<>(processes));
                break;
            case 2:
                SJFScheduler.schedule(new ArrayList<>(processes));
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
