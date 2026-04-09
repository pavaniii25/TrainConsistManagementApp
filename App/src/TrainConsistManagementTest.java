import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;


public class TrainConsistManagementTest {

    private static final int THRESHOLD = 70;

    // Method under test
    private List<Integer> filterBogies(List<Integer> bogies) {
        return bogies.stream()
                .filter(b -> b > THRESHOLD)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Integer> bogies = Arrays.asList(60, 75, 80, 50);

        List<Integer> result = filterBogies(bogies);

        assertTrue(result.contains(75));
        assertTrue(result.contains(80));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Integer> bogies = Arrays.asList(70, 80);

        List<Integer> result = filterBogies(bogies);

        assertFalse(result.contains(70));
        assertTrue(result.contains(80));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Integer> bogies = Arrays.asList(60, 65);

        List<Integer> result = filterBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Integer> bogies = Arrays.asList(72, 75, 90);

        List<Integer> result = filterBogies(bogies);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Integer> bogies = Arrays.asList(40, 50, 60);

        List<Integer> result = filterBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Integer> bogies = Arrays.asList(80, 85, 90);

        List<Integer> result = filterBogies(bogies);

        assertEquals(bogies, result);
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Integer> bogies = new ArrayList<>();

        List<Integer> result = filterBogies(bogies);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Integer> bogies = new ArrayList<>(Arrays.asList(60, 75, 80));
        List<Integer> originalCopy = new ArrayList<>(bogies);

        filterBogies(bogies);

        assertEquals(originalCopy, bogies);
    }
}