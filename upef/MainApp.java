package upef;

import java.util.Scanner;
import upef.dao.TaskManager;
import upef.metier.TaskOperation;
import upef.metier.impl.DisplayTasks;

public class MainApp {

    private TaskManager taskManager = null;
    private Scanner scanner;

    public MainApp() {
       // taskManager = new TaskManagerImpl();
        scanner = new Scanner(System.in);
    }

    public void start() {
        //taskManager.loadTasks(); // Charger les tâches depuis le fichier
        boolean quit = false;
        while (!quit) {
            displayMenu();
            TaskOperation operation = null; // Opération à effectuer
            int choice = scanner.nextInt();
            scanner.nextLine(); // Lire le retour chariot après le numéro
		
            switch (choice) {
                case 1:
                    operation = new DisplayTasks(taskManager);
                    break;
                case 2:
                   //operation =  new AddTask(taskManager, scanner);
                    break;
                case 3:
                   // operation = new MarkTaskCompleted(taskManager, scanner);
                    break;
                case 4:
                    //operation = new DeleteTask(taskManager, scanner);
                    break;
                case 5:
                    //taskManager.saveTasks();
                    quit = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un numéro valide.");
            }

        if(operation != null) {
		    operation.process();
        }

        System.out.println("Merci d'avoir utilisé l'application TODO-list.");
        }
    }

    private void displayMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Afficher les tâches");
        System.out.println("2. Ajouter une nouvelle tâche");
        System.out.println("3. Marquer une tâche comme complétée");
        System.out.println("4. Supprimer une tâche");
        System.out.println("5. Quitter");
        System.out.print("Choix : ");
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.start();
    }
    
}
