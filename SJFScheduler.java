import java.util.*;

// shortest job first (SJF) scheduler
public class SJFScheduler {

    // method to schedule the processes
    public static void schedule(List<Process> processes) {
        // sort the processes by burst time
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        PriorityQueue<Process> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.burstTime));
        // initialize the current time and the index of the next process to be executed
        int currentTime = 0, index = 0;
        List<Process> executedProcesses = new ArrayList<>();
        while (index < processes.size() || !pq.isEmpty()) {
            while (index < processes.size() && processes.get(index).arrivalTime <= currentTime) {
                pq.add(processes.get(index++));
            }
            // if the priority queue is not empty, execute the process with the shortest burst time
            if (!pq.isEmpty()) {
                Process p = pq.poll();
                p.waitingTime = currentTime - p.arrivalTime;
                p.turnaroundTime = p.waitingTime + p.burstTime;
                currentTime += p.burstTime;
                executedProcesses.add(p);
            } else {
                currentTime = processes.get(index).arrivalTime;
            }
        }
        displayResults("Shortest Job First (SJF)", executedProcesses);
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
