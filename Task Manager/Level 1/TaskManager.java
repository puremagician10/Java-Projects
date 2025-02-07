import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private static final String FILE_NAME = "tasks.txt";
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        loadTasksFromFile();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markComplete(scanner);
                    break;
                case 4:
                    deleteTask(scanner);
                    break;
                case 5:
                    saveTasksToFile();
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String desc = scanner.nextLine();
        System.out.print("Enter due date (DD-MM-YYYY): ");
        String date = scanner.nextLine();

        tasks.add(new Task(nextId++, desc, date));
        System.out.println("Task added!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
            return;
        }

        System.out.println("\nID | Description | Due Date | Status");
        for (Task task : tasks) {
            System.out.printf("%d | %s | %s | %s%n",
                    task.getId(),
                    task.getDescription(),
                    task.getDueDate(),
                    task.isCompleted() ? "Completed" : "Pending");
        }
    }

    private static void markComplete(Scanner scanner) {
        System.out.print("Enter task ID to mark complete: ");
        int id = scanner.nextInt();
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markComplete();
                System.out.println("Task marked complete!");
                return;
            }
        }
        System.out.println("Task not found!");
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task deleted!");
    }

    private static void loadTasksFromFile() {
        try (Scanner fileScanner = new Scanner(new File(FILE_NAME))) {
            while (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split(",");
                Task task = new Task(Integer.parseInt(data[0]), data[1], data[2]);
                if (Boolean.parseBoolean(data[3])) task.markComplete();
                tasks.add(task);
                nextId = task.getId() + 1;
            }
        } catch (IOException e) {
            // File not found - first run
        }
    }

    private static void saveTasksToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Task task : tasks) {
                writer.write(String.format("%d,%s,%s,%s%n",
                        task.getId(),
                        task.getDescription(),
                        task.getDueDate(),
                        task.isCompleted()));
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks!");
        }
    }
}
