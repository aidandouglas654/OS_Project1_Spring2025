import java.util.*;

// first-come, first-served (FCFS) scheduler
public class FCFSScheduler {

    // method to schedule the processes
    public static void schedule(List<Process> processes) {
        // sort the processes by arrival time
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        // initialize the current time and the index of the next process to be executed
        int currentTime = 0;
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }
            p.waitingTime = currentTime - p.arrivalTime;
            p.turnaroundTime = p.waitingTime + p.burstTime;
            currentTime += p.burstTime;
        }
        displayResults("First-Come, First-Served (FCFS)", processes);
    }

    private static void displayResults(String algorithm, List<Process> processes) {
        System.out.println("\n=== " + algorithm + " ===");
        int totalWT = 0, totalTAT = 0;
        System.out.println("PID | Arrival | Burst | Waiting | Turnaround");
        for (Process p : processes) {
            System.out.printf("%3d | %7d | %5d | %7d | %10d\n", p.pid, p.arrivalTime, p.burstTime, p.waitingTime, p.turnaroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }
        // calculate and display the average waiting time and average turnaround time
        System.out.printf("\nAverage Waiting Time: %.2f\n", (double) totalWT / processes.size());
        System.out.printf("Average Turnaround Time: %.2f\n", (double) totalTAT / processes.size());
    }
}
