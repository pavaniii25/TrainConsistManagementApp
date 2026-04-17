import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementTest {

    // Regex patterns
    private static final Pattern TRAIN_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    // Helper methods
    private boolean isValidTrainId(String input) {
        return input != null && TRAIN_PATTERN.matcher(input).matches();
    }

    private boolean isValidCargoCode(String input) {
        return input != null && CARGO_PATTERN.matcher(input).matches();
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrainId("TRAIN12"));
        assertFalse(isValidTrainId("TRN12A"));
        assertFalse(isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargoCode("PET-ab"));   // lowercase
        assertFalse(isValidCargoCode("PET123"));   // no dash
        assertFalse(isValidCargoCode("AB-PET"));   // wrong order
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrainId("TRN-123"));    // 3 digits
        assertFalse(isValidTrainId("TRN-12345"));  // 5 digits
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargoCode("PET-Ab"));
        assertFalse(isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrainId(""));
        assertFalse(isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrainId("TRN-1234X")); // extra char
        assertFalse(isValidCargoCode("X PET-AB")); // extra prefix
    }
}