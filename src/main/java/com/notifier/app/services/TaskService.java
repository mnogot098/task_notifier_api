package com.notifier.app.services;

import com.notifier.app.models.Task;
import com.notifier.app.models.User;
import com.notifier.app.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

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
}
