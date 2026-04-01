import java.util.HashMap;

import java.util.Map;

public class TrainConsistManagement {


                public static void main(String[] args) {

                    System.out.println("=== UC6 Map Bogie to Capacity (HashMap) ===");
                    System.out.println();

                    // HashMap stores data in key-value format
                    Map<String, Integer> capacityMap = new HashMap<>();

                    // Insert bogie capacities
                    capacityMap.put("First Class", 24);
                    capacityMap.put("Cargo", 120);
                    capacityMap.put("Sleeper", 72);
                    capacityMap.put("AC Chair", 56);

                    // Display bogie and capacity details
                    System.out.println("Bogie Capacity Details:");
                    for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
                        System.out.print(entry.getKey() + " -> " + entry.getValue() + "  ");
                    }
                    System.out.println(); // For newline

                    // Completion message
                    System.out.println("\nUC6 bogie-capacity mapping completed...");
                }
            }


















