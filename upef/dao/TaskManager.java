package upef.dao;

import java.util.List;

import upef.om.Task;

public interface TaskManager {

    List<Task> getTasks();
    void addTask(Task task);
    void removeTask(int id);
    void saveTasks();
    void loadTasks();
}