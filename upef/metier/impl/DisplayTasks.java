package upef.metier.impl;

import upef.dao.TaskManager;
import upef.metier.TaskOperation;
import upef.om.Task;

public class DisplayTasks implements TaskOperation {
    private TaskManager taskManager;

    public DisplayTasks(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void process() {
        System.out.println("\n===== Liste des tâches =====");
        for (int i = 0; i < taskManager.getTasks().size(); i++) {
            Task task = taskManager.getTasks().get(i);
            System.out.printf("%d. [%s] %s\n", i + 1, task.isCompleted() ? "X" : " ", task.getDescription());
        }
    }
}

