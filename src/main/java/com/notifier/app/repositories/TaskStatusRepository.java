package com.notifier.app.repositories;

import com.notifier.app.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus,Integer> {
}
