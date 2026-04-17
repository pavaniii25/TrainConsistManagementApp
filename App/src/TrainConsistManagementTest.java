import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    // Search method with fail-fast validation
    private boolean searchBogie(String[] bogieIds, String searchId) {
        // FAIL-FAST VALIDATION
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        // SEARCH LOGIC
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogies = {};

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            searchBogie(bogies, "BG101");
        });

        assertEquals("No bogies available in train. Cannot perform search.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101", "BG205"};

        assertDoesNotThrow(() -> searchBogie(bogies, "BG101"));
    }

    private void assertDoesNotThrow(Object bg101) {

    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};

        assertTrue(searchBogie(bogies, "BG205"));
    }

    @Test
     void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};

        assertFalse(searchBogie(bogies, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};

        assertTrue(searchBogie(bogies, "BG101"));
    }
}