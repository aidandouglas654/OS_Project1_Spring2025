import java.io.*;
import java.util.*;

public class ProcessReader {
    public static List<Process> readProcessesFromFile(String filename) {
        List<Process> processes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 4) {
                    int pid = Integer.parseInt(parts[0]);
                    int arrival = Integer.parseInt(parts[1]);
                    int burst = Integer.parseInt(parts[2]);
                    int priority = Integer.parseInt(parts[3]);
                    processes.add(new Process(pid, arrival, burst, priority));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return processes;
    }

    public static void main(String[] args) {
        List<Process> processes = readProcessesFromFile("processes.txt");
        for (Process process : processes) {
            System.out.println(process);
        }
    }
}
