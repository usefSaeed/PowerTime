package com.barmjz.productivityapp.todo_mindmap.task;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
        try {
            return ResponseEntity.ok(taskService.getTask(taskId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        try {
            return ResponseEntity.ok(taskService.updateTask(taskId, task));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task, @RequestParam String taskType) {
        try {
            return ResponseEntity.ok(taskService.createTask(task, taskType));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PutMapping("/{taskId}/tick")
    public ResponseEntity<Task> tickTask(@PathVariable Long taskId, @RequestParam Long date, @RequestParam String taskType){
        return null;
    }
    @PutMapping("/{taskId}/untick")
    public ResponseEntity<Task> untickTask(@PathVariable Long taskId, @RequestParam Long date, @RequestParam String taskType){
        return null;
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getCompletedTasks(){
        return null;
    }


}
