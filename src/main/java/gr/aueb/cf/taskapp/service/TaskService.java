package gr.aueb.cf.taskapp.service;

import gr.aueb.cf.taskapp.dto.TaskDTO;
import gr.aueb.cf.taskapp.model.Task;
import gr.aueb.cf.taskapp.model.User;
import gr.aueb.cf.taskapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskRepository taskRepository;


    public List<Task> getAllTasksForAuthenticatedUser(String username) {
        Optional<User> user = userService.getUserbyUsername(username);
        if (user.isPresent()) {
            return taskRepository.findTaskByUserId(user.get().getId());
        }
        return List.of();
    }

    // Create a new task
    public void createTask(TaskDTO taskDTO, String username) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setUser(userService.getUserbyUsername(username).orElse(null));
        taskRepository.save(task);  // Save the task to the database
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id); // Delete the task by ID
    }
}
