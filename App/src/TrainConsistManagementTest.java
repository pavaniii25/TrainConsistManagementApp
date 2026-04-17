import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {


    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        int getCapacity() {
            return capacity;
        }
    }


    private List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }


    private List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 70),
                new Bogie("C", 80)
        );

        List<Bogie> result = filterWithLoop(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 70),
                new Bogie("C", 80)
        );

        List<Bogie> result = filterWithStream(bogies);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 40),
                new Bogie("B", 65),
                new Bogie("C", 90)
        );

        List<Bogie> loopResult = filterWithLoop(bogies);
        List<Bogie> streamResult = filterWithStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Type", i));
        }

        long start = System.nanoTime();
        filterWithStream(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Type", i));
        }

        List<Bogie> result = filterWithStream(bogies);

        assertNotNull(result);
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }
}