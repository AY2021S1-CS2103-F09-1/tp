---
layout: page
title: Joshua Chew's Project Portfolio Page
---

## Project: TAskmaster

TAskmaster is a desktop app for managing students, optimised for use via a Command Line Interface (CLI) while still 
having the benefits of a Graphical User Interface (GUI). If you are a CS Teaching Assistant who can type fast, 
TAskmaster can help you track your students' attendance and class participation faster than traditional GUI apps.

This application contains a central database of students, and supports operations to add, edit and delete students. 
Each entry in the database keeps track of a student's name, NUSNET ID, Telegram handle and email address.

It also supports commands to add and delete tutorial sessions. Each tutorial session contains an independent list of
student records. A Teaching Assistant (TA) has the option to mark attendances and assign class participation scores to 
each student in a session. He or she is also able to mark the attendance or assign a score to all students within a 
session in one command.

Given below are my contributions to the project.

- **New Feature:** Added the ability to add sessions to TAskmaster.
    - What it does: Allows a TA to add a new session to TAskmaster with a specified session name, date and time.
    The new session would also contain a list of student records.
    - Justification: This feature is essential to the product as a TA should be able to create multiple sessions and
    name them according to his preferences.
    - Highlights: This enhancement requires the implementation of a `Session` class and a `SessionList` as a data
    structure that supports the addition of sessions. This was challenging as it requires an in-depth analysis of design
    alternatives, and a decision to be made on which stage in the code's execution should the `StudentRecordList` be
    initialized in the new session.

- **New Feature:** Added the ability to toggle between current sessions in TAskmaster.
    - What it does: Allows a TA to choose which session's student records to view in the GUI.
    - Justification: As a TA would likely create multiple sessions in the application, it is important to allow a TA to
    be able to choose which session's records to view or perform commands on.
    - Highlights: This enhancement requires some contemplation to be made on how the `Model` class should be redesigned
    such that it contains information on which session is currently selected. It also has to support the corner case
    where the TAskmaster is being used for the first time, where no sessions has been created yet and the pointer to the
    current session is `null`. This implementation is challenging as it has to ensure that such corner cases would not
    present unexpected bugs.

- **New Feature:** Added the ability to delete a session in TAskmaster.
    - What it does: Allows a TA to delete a session with the specified session name from the session list.
    - Justification: This feature improves the usability of the product. TAs can potentially made mistakes when adding
    sessions. For example, he could have mistyped the name of a session, or keyed in the wrong date and time. In such
    cases, a TA can easily delete the session from the application.
    - Highlights: This enhancement requires careful testing to ensure that all potential bugs are eliminated. For
    example, I made sure that sessions within the TAskmaster cannot possess the same name, such that there would be no
    issues when deleting a session with a specific session name.

- **New Feature:** Renamed the commands such that it is easier to differentiate between student-related and
session-related commands.
    - Justification: Some commands have similar names. It is important for the TA to be clear on whether a command acts
    on a student or a session. Prior to the renaming, the command to add a student to the student list was `add`,
    whereas that of adding a new session was `session`. This made the functionality of `add` sound ambiguous and 
    confusing. Now, the former is named `add-student`, and the latter is named `add-session`.

- **Code contributed:** [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=josuaaah)

- **Enhancements to existing features:**
    - Wrote additional tests for existing features to increase code coverage (Pull requests 
    [#57](https://github.com/AY2021S1-CS2103-F09-1/tp/pull/57) and [#171](https://github.com/AY2021S1-CS2103-F09-1/tp/pull/171)).

- **Documentation:**
    - User Guide:
        - Added documentation for the features `add-session`, `goto` and `delete-session`.
    - Developer Guide:
        - Added implementation details for the `Session` and `SessionList` feature. [#79](https://github.com/AY2021S1-CS2103-F09-1/tp/pull/79)

- **Contribution to team-based tasks:**
    - Wrote the AboutUs page [#26](https://github.com/AY2021S1-CS2103-F09-1/tp/pull/26)
    - Updated the README [#35](https://github.com/AY2021S1-CS2103-F09-1/tp/pull/35)

- **Community:**
    - PRs reviewed and [approved](https://github.com/AY2021S1-CS2103-F09-1/tp/pulls?q=is%3Apr+is%3Aclosed+review%3Aapproved)
    - Contributed to forum discussions (Examples: [1](https://github.com/nus-cs2103-AY2021S1/forum/issues/266), 
    [2](https://github.com/nus-cs2103-AY2021S1/forum/issues/139))










