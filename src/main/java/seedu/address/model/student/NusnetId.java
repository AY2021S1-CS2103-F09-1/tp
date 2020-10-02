package seedu.address.model.student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidNusnetId(String)}
 */
public class NusnetId {

    public static final String MESSAGE_CONSTRAINTS =
            "NusnetId needs to start with e, followed by 0, followed by 6 more numerical digits.";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^e0[0-9]{6}";

    public final String value;

    /**
     * Constructs an {@code NusnetId}.
     *
     * @param address A valid address.
     */
    public NusnetId(String address) {
        requireNonNull(address);
        checkArgument(isValidNusnetId(address), MESSAGE_CONSTRAINTS);
        value = address;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidNusnetId(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NusnetId // instanceof handles nulls
                && value.equals(((NusnetId) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
