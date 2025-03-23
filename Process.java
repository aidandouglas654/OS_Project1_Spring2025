// Represents a process with its arrival time, burst time, and priority 
public class Process {
    int pid;
    int arrivalTime;
    int burstTime;
    int priority;
    int waitingTime; 
    int turnaroundTime; 

    // Constructor to inialize the process with its pid, arrival time, burst time, and priority
    public Process(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;   // Initialize
        this.turnaroundTime = 0; // Initialize
    }
}
