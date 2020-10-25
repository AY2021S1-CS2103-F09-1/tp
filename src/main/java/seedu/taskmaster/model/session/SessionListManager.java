package seedu.taskmaster.model.session;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.taskmaster.model.session.exceptions.DuplicateSessionException;
import seedu.taskmaster.model.session.exceptions.SessionNotFoundException;
import seedu.taskmaster.model.student.exceptions.DuplicateStudentException;

import java.util.Iterator;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static seedu.taskmaster.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents a list of sessions.
 */
public class SessionListManager implements SessionList {

    private final ObservableList<Session> internalList = FXCollections.observableArrayList();
    private final ObservableList<Session> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Initialises an {@code SessionListManager} with the given {@code sessions}.
     */
    public static SessionList of(List<Session> sessions) {
        SessionList sessionList = new SessionListManager();
        sessionList.setSessions(sessions);
        return sessionList;
    }

    @Override
    public Session get(SessionName sessionName) throws SessionNotFoundException {
        for (int i = 0; i < getNumberOfSessions(); i++) {
            if (internalList.get(i).getSessionName().equals(sessionName)) {
                return internalList.get(i);
            }
        }
        throw new SessionNotFoundException();
    }

    public int getNumberOfSessions() {
        return internalList.size();
    }

    /**
     * Returns true if the session list contains {@code session}.
     */
    @Override
    public boolean contains(Session session) {
        return internalList.contains(session);
    }

    /**
     * Returns true if the session list contains a session with {@code sessionName}.
     */
    public boolean contains(SessionName sessionName) {
        for (Session session : internalList) {
            if (session.getSessionName().equals(sessionName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Session toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateSessionException();
        }
        internalList.add(toAdd);
    }

    @Override
    public void setSessions(SessionListManager replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code sessions}.
     * {@code sessions} must not contain duplicate sessions.
     */
    @Override
    public void setSessions(List<Session> sessions) {
        requireAllNonNull(sessions);
        if (!sessionsAreUnique(sessions)) {
            throw new DuplicateSessionException();
        }
        internalList.setAll(sessions);
    }

    /**
     * Returns true if {@code sessions} contains only unique sessions.
     */
    private boolean sessionsAreUnique(List<Session> sessions) {
        for (int i = 0; i < sessions.size() - 1; i++) {
            for (int j = i + 1; j < sessions.size(); j++) {
                if (sessions.get(i).equals(sessions.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the session list as an unmodifiable {@code ObservableList}
     */
    @Override
    public ObservableList<Session> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Session> iterator() {
        return internalList.iterator();
    }
}
