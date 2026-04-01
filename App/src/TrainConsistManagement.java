
import java.util.HashSet;

import java.util.Set;

public class TrainConsistManagement {


 UC3
       Set<String> bogies= new HashSet<>();

        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        bogies.add("BG101");
        bogies.add("BG102");

        System.out.println("Bogie IDs After Insertion: " + bogies);


        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet");

        System.out.println("\nUC3 uniqueness validation completed...");
    }
}

















