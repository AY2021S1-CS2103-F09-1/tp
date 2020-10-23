package seedu.taskmaster.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.taskmaster.logic.parser.CliSyntax.PREFIX_ATTENDANCE_TYPE;

import java.util.List;

import seedu.taskmaster.logic.commands.exceptions.CommandException;
import seedu.taskmaster.model.Model;
import seedu.taskmaster.model.session.AttendanceType;
import seedu.taskmaster.model.student.Student;

public class MarkAllCommand extends MarkCommand {
    public static final String COMMAND_WORD = "mark all";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks attendances of all students in the student list.\n"
            + "Parameters: "
            + PREFIX_ATTENDANCE_TYPE + "ATTENDANCE_TYPE (must be 'present' or 'absent') \n"
            + "Example: " + COMMAND_WORD + PREFIX_ATTENDANCE_TYPE + "present";

    public static final String MESSAGE_MARK_ALL_SUCCESS = "Marked all students as %1$s";

    public MarkAllCommand(AttendanceType attendanceType) {
        super(null, attendanceType);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Student> lastShownList = model.getFilteredStudentList();

        model.markAllStudents(lastShownList, attendanceType);
        return new CommandResult(String.format(MESSAGE_MARK_ALL_SUCCESS, attendanceType));
    }
}
