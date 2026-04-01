import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainConsistManagement {

        static class Bogie {
            String name;
            int capacity;

            Bogie(String name, int capacity) {
                this.name = name;
                this.capacity = capacity;
            }

            @Override
            public String toString() {
                return name + " -> " + capacity;
            }
        }

        public static void main(String[] args) {
            System.out.println("\nUC9 Group Bogies by Type\n====================\n");

            // Create list of bogies
            List<Bogie> bogies = new ArrayList<>();
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));
            bogies.add(new Bogie("Sleeper", 70));
            bogies.add(new Bogie("AC Chair", 60));

            // Display all bogies
            System.out.println("All Bogies:");
            bogies.forEach(System.out::println);

            // Group bogies by type using Collectors.groupingBy
            Map<String, List<Bogie>> groupedBogies = bogies.stream()
                    .collect(Collectors.groupingBy(b -> b.name));

            // Display grouped structure
            System.out.println("\nGrouped Bogies:");
            for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
                System.out.println("Bogie Type: " + entry.getKey());
                entry.getValue().forEach(b -> System.out.println("Capacity -> " + b.capacity));
            }

            System.out.println("\nUC9 grouping completed...");
        }
    }












