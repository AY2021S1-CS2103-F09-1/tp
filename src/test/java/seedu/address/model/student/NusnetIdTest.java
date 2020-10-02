package seedu.address.model.student;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NusnetIdTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new NusnetId(null));
    }

    @Test
    public void constructor_invalidAddress_throwsIllegalArgumentException() {
        String invalidAddress = "";
        assertThrows(IllegalArgumentException.class, () -> new NusnetId(invalidAddress));
    }

    @Test
    public void isValidAddress() {
        // null address
        assertThrows(NullPointerException.class, () -> NusnetId.isValidNusnetId(null));

        // invalid addresses
        assertFalse(NusnetId.isValidNusnetId("")); // empty string
        assertFalse(NusnetId.isValidNusnetId(" ")); // spaces only
        assertFalse(NusnetId.isValidNusnetId("e")); // e only
        assertFalse(NusnetId.isValidNusnetId("e1123456")); // e not followed by 0
        assertFalse(NusnetId.isValidNusnetId("e01234567")); // one extra length

        // valid addresses
        assertTrue(NusnetId.isValidNusnetId("e0123456"));
    }
}
