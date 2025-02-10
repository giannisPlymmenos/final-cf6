package gr.aueb.cf.taskapp.repository;

import gr.aueb.cf.taskapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByUserId(long user_id);
}
