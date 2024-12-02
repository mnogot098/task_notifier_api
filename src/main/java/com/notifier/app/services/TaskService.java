package com.notifier.app.services;

import com.notifier.app.models.Task;
import com.notifier.app.models.TaskStatus;
import com.notifier.app.models.User;
import com.notifier.app.repositories.TaskRepository;
import com.notifier.app.repositories.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskStatusRepository taskStatusRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByUserId(Integer userId) {
        // Create a User object with the given userId
        User user = new User();
        user.setUserId(userId);

        // Find tasks by user object
        return taskRepository.findByUser(user);
    }
    public List<TaskStatus> getTaskStatus() {
        return taskStatusRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
