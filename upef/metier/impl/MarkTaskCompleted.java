package metier.impl;

import java.util.Scanner;

import upef.dao.TaskManager;
import upef.metier.TaskOperation;
import upef.om.Task;

public class MarkTaskCompleted  implements TaskOperation{
    private TaskManager taskManager;

    private Scanner scanner;

    public MarkTaskCompleted(TaskManager taskManager, Scanner scanner) {
        this.taskManager = taskManager;
        this.scanner = scanner;
    }

    public void process() {
        System.out.print("Entrez le numéro de la tâche à marquer comme complétée : ");
        int index = scanner.nextInt();
        if (index > 0 && index <= taskManager.getTasks().size()) {
            Task task = taskManager.getTasks().get(index - 1);
            task.setCompleted(true);
            System.out.println("La tâche a été marquée comme complétée.");
        } else {
            System.out.println("Numéro de tâche invalide.");
        }
    }
}

