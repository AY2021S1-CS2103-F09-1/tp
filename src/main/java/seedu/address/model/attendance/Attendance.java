package seedu.address.model.attendance;

import seedu.address.model.student.NusnetId;

/**
 * Represents a student's attendance.
 */
public class Attendance {
    private static final String STRING_FORMAT = "%s|%s";

    private final NusnetId nusnetId;
    private AttendanceType attendanceType;

    /**
     * The student is represented by their {@code nusnetId} and initially marked with {@code NO_RECORD}.
     */
    public Attendance(NusnetId nusnetId) {
        this.nusnetId = nusnetId;
        this.attendanceType = AttendanceType.NO_RECORD;
    }

    /**
     * Creates an Attendance object with the AttendanceType already specified.
     */
    public Attendance(NusnetId nusnetId, AttendanceType attendanceType) {
        this.nusnetId = nusnetId;
        this.attendanceType = attendanceType;
    }

    public NusnetId getNusnetId() {
        return nusnetId;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(AttendanceType attendanceType) {
        this.attendanceType = attendanceType;
    }

    @Override
    public String toString() {
        return String.format(STRING_FORMAT, nusnetId, attendanceType.name());
    }
}
