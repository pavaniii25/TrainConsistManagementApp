import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    // Binary Search Method (with sorting precondition handled)
    private boolean binarySearch(String[] bogieIds, String key) {
        if (bogieIds.length == 0) return false;

        Arrays.sort(bogieIds); // ensure sorted

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = bogieIds[mid].compareTo(key);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(binarySearch(bogies, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(binarySearch(bogies, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(binarySearch(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(binarySearch(bogies, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogies = {"BG101"};

        assertTrue(binarySearch(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogies = {};

        assertFalse(binarySearch(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogies = {"BG309","BG101","BG550","BG205","BG412"};

        assertTrue(binarySearch(bogies, "BG205"));
    }
}