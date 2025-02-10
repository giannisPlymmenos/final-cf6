package gr.aueb.cf.taskapp.controller;

import gr.aueb.cf.taskapp.dto.UserDTO;
import gr.aueb.cf.taskapp.service.UserService;
import gr.aueb.cf.taskapp.dto.TaskDTO;

import gr.aueb.cf.taskapp.model.Task;
import gr.aueb.cf.taskapp.model.User;
import gr.aueb.cf.taskapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/add")
    public String showTaskForm(Model model) {
        model.addAttribute("taskDTO", new TaskDTO());
        return "add";
    }

    @PostMapping("/add")
    public String createTask(@ModelAttribute("taskDTO") TaskDTO taskDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        taskService.createTask(taskDTO, username);
        return "success";
    }


    @GetMapping
    public String listTasks(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Task> tasks = taskService.getAllTasksForAuthenticatedUser(username);
        model.addAttribute("username", username);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
