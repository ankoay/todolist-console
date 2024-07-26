package upef.metier.impl;

import java.util.Scanner;

import upef.dao.TaskManager;
import upef.metier.TaskOperation;
import upef.om.Task;

public class AddTask  implements TaskOperation{
    private TaskManager taskManager;
    private Scanner scanner;

    public AddTask(TaskManager taskManager, Scanner scanner) {
        this.taskManager = taskManager;
        this.scanner = scanner;
    }

    public void process() {
        System.out.print("Entrez la description de la nouvelle tâche : ");
        String description = scanner.nextLine();
        taskManager.addTask(new Task(description));
        System.out.println("Nouvelle tâche ajoutée.");
    }
}

