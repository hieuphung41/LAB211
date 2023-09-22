package J1SP0071;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManagement {

    List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
        System.err.println("Added successfully!");
    }

    public void deleteTask(int id) {
        Task task = getTaskByID(id);
        if (task != null) {
            taskList.remove(task);
            System.err.println("Removed successfully!");
        } else {
            System.err.println("Not found!");
        }
    }

    public void showTask() {
        Collections.sort(taskList, (Task o1, Task o2) -> {
            if (o1.getId() > o2.getId()) {
                return 1;
            } else if (o1.getId() == o2.getId()) {
                return 0;
            } else {
                return -1;
            }
        });
        System.out.println("ID - TaskTypeID - Name - Date - Time - Assignee - Reviewer");
        for (Task x : taskList) {
            System.out.println(x.getId() + " - "
                    + x.getTaskTypeID() + " - "
                    + x.getName() + " - "
                    + x.getDate() + " - "
                    + (x.getPlanTo() - x.getPlanFrom()) + " - "
                    + x.getAssignee() + " - "
                    + x.getReviewer());
        }
    }

    public Task getTaskByID(int id) {
        for (Task x : taskList) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }
}
