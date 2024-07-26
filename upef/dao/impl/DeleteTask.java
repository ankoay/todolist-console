package upef.dao.impl;

import java.util.Scanner;

import upef.dao.TaskManager;
import upef.metier.TaskOperation;

public class DeleteTask  implements TaskOperation {
    private TaskManager taskManager;
    private Scanner scanner;

    public DeleteTask(TaskManager taskManager, Scanner scanner) {
        this.taskManager = taskManager;
        this.scanner = scanner;
    }

    public void process() {
        System.out.print("Entrez le numéro de la tâche à supprimer : ");
        int index = scanner.nextInt();
        if (index > 0 && index <= taskManager.getTasks().size()) {
            taskManager.removeTask(index - 1);
            System.out.println("La tâche a été supprimée.");
        } else {
            System.out.println("Numéro de tâche invalide.");
        }
    }
}

