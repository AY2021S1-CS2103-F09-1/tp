package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NUSNETID_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalStudents.ALICE;
import static seedu.address.testutil.TypicalStudents.getTypicalTaskmaster;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.student.Student;
import seedu.address.model.student.exceptions.DuplicateStudentException;
import seedu.address.testutil.StudentBuilder;

public class TaskmasterTest {

    private final Taskmaster taskmaster = new Taskmaster();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), taskmaster.getStudentList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> taskmaster.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyTaskmaster_replacesData() {
        Taskmaster newData = getTypicalTaskmaster();
        taskmaster.resetData(newData);
        assertEquals(newData, taskmaster);
    }

    @Test
    public void resetData_withDuplicateStudents_throwsDuplicateStudentException() {
        // Two students with the same identity fields
        Student editedAlice = new StudentBuilder(ALICE).withNusnetId(VALID_NUSNETID_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Student> newStudents = Arrays.asList(ALICE, editedAlice);
        TaskmasterStub newData = new TaskmasterStub(newStudents);

        assertThrows(DuplicateStudentException.class, () -> taskmaster.resetData(newData));
    }

    @Test
    public void hasStudent_nullStudent_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> taskmaster.hasStudent(null));
    }

    @Test
    public void hasStudent_studentNotInStudentList_returnsFalse() {
        assertFalse(taskmaster.hasStudent(ALICE));
    }

    @Test
    public void hasStudent_studentInStudentList_returnsTrue() {
        taskmaster.addStudent(ALICE);
        assertTrue(taskmaster.hasStudent(ALICE));
    }

    @Test
    public void hasStudent_studentWithSameIdentityFieldsInStudentList_returnsTrue() {
        taskmaster.addStudent(ALICE);
        Student editedAlice = new StudentBuilder(ALICE).withNusnetId(VALID_NUSNETID_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(taskmaster.hasStudent(editedAlice));
    }

    @Test
    public void getStudentList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> taskmaster.getStudentList().remove(0));
    }

    /**
     * A stub ReadOnlyTaskmaster whose students list can violate interface constraints.
     */
    private static class TaskmasterStub implements ReadOnlyTaskmaster {
        private final ObservableList<Student> students = FXCollections.observableArrayList();

        TaskmasterStub(Collection<Student> students) {
            this.students.setAll(students);
        }

        @Override
        public ObservableList<Student> getStudentList() {
            return students;
        }
    }

}
