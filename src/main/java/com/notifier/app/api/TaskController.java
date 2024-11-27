package com.notifier.app.api;

import com.notifier.app.models.Task;
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
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public Map<String, Object> getTasksByUserId(@RequestBody User user) {
        List<Task> tasks = taskService.getTasksByUserId(user.getUserId());
        return Map.of("tasks", tasks);
    }
}
