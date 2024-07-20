package upef.dao.impl;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import upef.dao.TaskManager;
import upef.om.Task;

public class TaskManagerImpl implements TaskManager {
    private List<Task> tasks;

    public TaskManagerImpl() {
        tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tasks.dat"))) {
            oos.writeObject(tasks);
            System.out.println("Tâches sauvegardées dans le fichier.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des tâches : " + e.getMessage());
        }
    }

    public void loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tasks.dat"))) {
            tasks = (List<Task>) ois.readObject();
            System.out.println("Tâches chargées depuis le fichier.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des tâches : " + e.getMessage());
        }
    }
}
