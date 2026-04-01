import java.util.LinkedList;
import java.util.List;

public class TrainConsistManagement {

    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println(" ===TrainConsistManagementApp=== ");
        System.out.println("===================================");

        List<String> trainConsist = new LinkedList<>();

        // Add initial bogies in sequence
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // Display initial train consist
        System.out.println("Initial Train Consist");
        System.out.println(trainConsist);

        // Insert 'Pantry Car' at position 2 (0-based index)
        trainConsist.add(2, "Pantry Car");
        System.out.println("\nAfter Inserting 'Pantry Car' at position 2");
        System.out.println(trainConsist);

        // Remove first and last bogie
        trainConsist.remove(0); // Remove first
        trainConsist.remove(trainConsist.size() - 1); // Remove last

        System.out.println("\nAfter Removing First and Last Bogie");
        System.out.println(trainConsist);

        // Completion message
        System.out.println("\nUC4 ordered consist operations completed...");
    }
}



















