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
        return "tasks/tasks"; // Nazwa pliku HTML w folderze resources/templates/tasks
    }

    @GetMapping("/addTask")
    public String getAddTask(Model model) {
        model.addAttribute("task", new TaskModel()); // Przekazujemy pusty obiekt TaskModel do formularza
        return "tasks/addTask"; // Nazwa pliku HTML w folderze resources/templates/tasks
    }

    @PostMapping("/tasks")
    public RedirectView postAddTask(@ModelAttribute TaskModel task) {
        taskService.saveTask(task);
        return new RedirectView("/tasks"); // Przekierowujemy z powrotem do listy zadań
    }

    @GetMapping("/tasks/edit/{id}")
    public String getEditTask(@PathVariable Long id, Model model) {
        TaskModel task = taskService.getTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task ID: " + id));
        model.addAttribute("task", task);
        return "tasks/editTask"; // Nazwa pliku HTML w folderze resources/templates/tasks
    }

    @PostMapping("/tasks/update/{id}")
    public RedirectView updateTask(@PathVariable Long id, @ModelAttribute TaskModel task) {
        task.setId(id); // Ustawiamy ID, aby upewnić się, że aktualizujemy istniejące zadanie
        taskService.saveTask(task);
        return new RedirectView("/tasks"); // Przekierowujemy z powrotem do listy zadań
    }

    @GetMapping("/tasks/delete/{id}")
    public RedirectView deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new RedirectView("/tasks"); // Przekierowujemy z powrotem do listy zadań
    }


}
