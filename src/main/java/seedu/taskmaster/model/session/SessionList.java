package seedu.taskmaster.model.session;

import javafx.collections.ObservableList;
import seedu.taskmaster.model.session.exceptions.SessionNotFoundException;

import java.util.List;

public interface SessionList extends Iterable<Session> {

    Session get(SessionName sessionName) throws SessionNotFoundException;

    /**
     * Returns true if the session list contains {@code session}.
     */
    boolean contains(Session session);

    boolean contains(SessionName sessionName);

    void add(Session toAdd);

    int getNumberOfSessions();

    void setSessions(SessionListManager replacement);

    /**
     * Replaces the contents of this list with {@code sessions}.
     * {@code sessions} must not contain duplicate sessions.
     */
    void setSessions(List<Session> sessions);

    /**
     * Returns the session list as an unmodifiable {@code ObservableList}
     */
    ObservableList<Session> asUnmodifiableObservableList();

}
