package com.notifier.app.repositories;

import com.notifier.app.models.Task;
import com.notifier.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {

    List<Task> findByUser(User user);
}
