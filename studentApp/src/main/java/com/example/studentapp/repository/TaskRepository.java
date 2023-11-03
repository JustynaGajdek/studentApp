package com.example.studentapp.repository;

import com.example.studentapp.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

=======
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    TaskModel saveTask(TaskModel task);
    List<TaskModel> getAllTasks();
    Optional<TaskModel> getTaskById(Long id);
    void deleteTask(Long id);
>>>>>>> ba92201 (poprawki w TaskRepository)
}