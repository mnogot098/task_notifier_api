package com.notifier.app.api;

import com.notifier.app.models.Task;
import com.notifier.app.models.TaskStatus;
import com.notifier.app.models.User;
import com.notifier.app.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/tasks")
@RestController
@AllArgsConstructor
public class TaskApiController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public Map<String, Object> getTasksByUserId(@RequestBody User user) {
        List<Task> tasks = taskService.getTasksByUserId(user.getUserId());
        return Map.of("tasks", tasks);
    }

    @GetMapping("/status")
    public Map<String, Object> getTaskStatusList() {
        List<TaskStatus> status = taskService.getTaskStatus();
        return Map.of("status",status);
    }

    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
}