package com.example.studentapp.controller;

import com.example.studentapp.model.TaskModel;
import com.example.studentapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getTaskList(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
<<<<<<< HEAD
        return "tasks/tasks"; // Nazwa pliku HTML w folderze resources/templates/tasks
=======
        return "tasks/tasks";
>>>>>>> ba92201 (poprawki w TaskRepository)
    }

    @GetMapping("/addTask")
    public String getAddTask(Model model) {
<<<<<<< HEAD
        model.addAttribute("task", new TaskModel()); // Przekazujemy pusty obiekt TaskModel do formularza
        return "tasks/addTask"; // Nazwa pliku HTML w folderze resources/templates/tasks
=======
        model.addAttribute("task", new TaskModel());
        return "tasks/addTask";
>>>>>>> ba92201 (poprawki w TaskRepository)
    }

    @PostMapping("/tasks")
    public RedirectView postAddTask(@ModelAttribute TaskModel task) {
        taskService.saveTask(task);
<<<<<<< HEAD
        return new RedirectView("/tasks"); // Przekierowujemy z powrotem do listy zadań
=======
        return new RedirectView("/tasks");
>>>>>>> ba92201 (poprawki w TaskRepository)
    }

    @GetMapping("/tasks/edit/{id}")
    public String getEditTask(@PathVariable Long id, Model model) {
        TaskModel task = taskService.getTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task ID: " + id));
        model.addAttribute("task", task);
<<<<<<< HEAD
        return "tasks/editTask"; // Nazwa pliku HTML w folderze resources/templates/tasks
=======
        return "tasks/editTask";
>>>>>>> ba92201 (poprawki w TaskRepository)
    }

    @PostMapping("/tasks/update/{id}")
    public RedirectView updateTask(@PathVariable Long id, @ModelAttribute TaskModel task) {
<<<<<<< HEAD
        task.setId(id); // Ustawiamy ID, aby upewnić się, że aktualizujemy istniejące zadanie
        taskService.saveTask(task);
        return new RedirectView("/tasks"); // Przekierowujemy z powrotem do listy zadań
=======
        task.setId(id);
        taskService.saveTask(task);
        return new RedirectView("/tasks");
>>>>>>> ba92201 (poprawki w TaskRepository)
    }

    @GetMapping("/tasks/delete/{id}")
    public RedirectView deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
<<<<<<< HEAD
        return new RedirectView("/tasks"); // Przekierowujemy z powrotem do listy zadań
=======
        return new RedirectView("/tasks");
>>>>>>> ba92201 (poprawki w TaskRepository)
    }


}
