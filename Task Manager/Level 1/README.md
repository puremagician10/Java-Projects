Task Manager with File Storage

Objective: Create a console-based task manager that lets users add, view, update, and delete tasks, with persistent storage in a text file.
-----------------------------------------------------------------------------------------------------------------------------------

Feature   | what you learn/practice
1. CRUD Operations - Creating, reading, updating, and deleting data (fundamental for any database/app).
2. File I/O - Reading from/writing to files for data persistence (File, FileWriter, Scanner).
3. Object-Oriented Programming - Designing a Task class with encapsulation (private fields, public methods).
4. Data Structures - Using ArrayList to store and manage collections of objects.
5. Input Validation - Handling user input safely (e.g., nextInt() vs. nextLine() edge cases).
6. Exception Handling - Gracefully handling file errors (e.g., try-catch blocks for file operations).
7. String Formatting - Using printf and String.format() for clean output and file storage.
8. Control Flow - switch statements, loops (while), and conditional logic.

----------------------------------------------------------------------------------------------------------------------------------

2. Key Technical Lessons
A. Object-Oriented Design
 - Encapsulation: The Task class hides its internal state (e.g., isCompleted) and exposes methods like markComplete().
 - Separation of Concerns: The Task class handles task data, while the TaskManager class manages logic and file operations.
B. File Persistence
 - Reading/Writing Text Files: Loading tasks from tasks.txt on startup and saving changes on exit.
 - Data Serialization: Storing task data as CSV (comma-separated values) in a file for simplicity.
C. Error Handling
 - Robust File Handling: Silent failure if the file doesn’t exist (first run) and error messages for write failures.
 - Input Safety: Using nextLine() after nextInt() to avoid input stream bugs.

----------------------------------------------------------------------------------------------------------------------------------

3. Architecture Highlights

Component | purpose
Task Class - Models a task with properties (ID, description, due date, status).
ArrayList<Task> - Stores tasks in memory during runtime.
loadTasksFromFile()	- Loads tasks from tasks.txt on startup.
saveTasksToFile() - Saves tasks to tasks.txt before exiting.
Menu-Driven Interface - Provides a user-friendly console UI with numbered options.









