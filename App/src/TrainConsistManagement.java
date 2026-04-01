import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagement {


        // Reusing Bogie model from UC7
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
            System.out.println("\nUCB Filter Passenger Bogies Using Streams\n====================\n");

            // Create list of passenger bogies (similar to UC7)
            List<Bogie> bogies = new ArrayList<>();
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));
            bogies.add(new Bogie("General", 90));

            // Display all bogies
            System.out.println("All Bogies");
            bogies.forEach(System.out::println);

            // Filter bogies with capacity >= 60
            List<Bogie> filteredBogies = bogies.stream()
                    .filter(b -> b.capacity >= 60)
                    .collect(Collectors.toList());

            // Display filtered bogies
            System.out.println("\nFiltered Bogies (Capacity >= 60)");
            filteredBogies.forEach(System.out::println);

            System.out.println("\nUCB Filtering completed...");
        }
    }















