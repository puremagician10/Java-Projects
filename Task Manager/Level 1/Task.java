public class Task {
    private int id;
    private String description;
    private String dueDate;
    private boolean isCompleted;

    public Task(int id, String description, String dueDate) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getDueDate() { return dueDate; }
    public boolean isCompleted() { return isCompleted; }

    public void markComplete() { isCompleted = true; }
    public void updateDescription(String newDesc) { description = newDesc; }
}
