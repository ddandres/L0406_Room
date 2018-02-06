# L0406_Room
Lecture 04.06 Room, DISCA - UPV, Development of apps for mobile devices.

Shows how to use Room to manage access to local databases.

The application enables the user to enter name, email address and phone number for her contacts. This information is locally stored in a SQLite database. The information can be accessedd, modified, and deleted at any time.

NOTE: Databases should be accessed on background tasks, so the main user interface is not blocked waiting for the operation to complete. This will be studied in Lecture 5 and, in this example, access to the database is blocking.
