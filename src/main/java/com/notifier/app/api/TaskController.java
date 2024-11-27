package com.notifier.app.api;

import com.notifier.app.models.Task;
import com.notifier.app.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/tasks")
@RestController
@AllArgsConstructor
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public Map<String, Object> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return Map.of("tasks", tasks);
    }
}
