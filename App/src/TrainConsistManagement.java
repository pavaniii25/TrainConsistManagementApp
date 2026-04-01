import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagement {

        public static void main(String[] args) {


            System.out.println("=== UCS Preserve Insertion Order of Bogies ===");
            System.out.println();

            // LinkedHashSet preserves insertion order and ensures uniqueness
            Set<String> formation = new LinkedHashSet<>();

            // Add bogies (including duplicates)
            formation.add("Engine");
            formation.add("Sleeper");
            formation.add("Cargo");
            formation.add("Guard");
            formation.add("Sleeper"); // Duplicate entry
            formation.add("Cargo");   // Duplicate entry

            // Display final train formation
            System.out.println("Final Train Formation:");
            System.out.println(formation);

            // Note about LinkedHashSet
            System.out.println("\nNote:");
            System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

            // Completion message
            System.out.println("\nUCS formation setup completed...");
        }
    }


















