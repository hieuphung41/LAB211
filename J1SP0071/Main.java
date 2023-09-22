package J1SP0071;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Validation validation = new Validation();
        TaskManagement tm = new TaskManagement();
        while (true) {
            menu();
            System.out.print("> Input your choice: ");
            int choice = validation.getIntInRange(1, 4);
            switch (choice) {
                case 1:

                    Task newTask = new Task();
                    tm.addTask(newTask.createTask());
                    break;
                case 2:
                    if (tm.taskList.isEmpty()) {
                        System.err.println("Task list is empty!");
                        break;
                    }
                    System.out.print("Input id to find: ");
                    tm.deleteTask(validation.getInt());
                    break;
                case 3:
                    if (tm.taskList.isEmpty()) {
                        System.err.println("Task list is empty!");
                        break;
                    }
                    tm.showTask();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("Invalid choice!");
            }
        }
    }

    public static void menu() {
        System.out.println("========== Function ==========");
        System.out.println("1. Add task");
        System.out.println("2. Delete task");
        System.out.println("3. Show task");
        System.out.println("4. Exit");
    }
}
