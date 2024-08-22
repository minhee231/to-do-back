package com.example.demo.controller;

import com.example.demo.entity.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getAllTodos(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id).orElseThrow( () -> new RuntimeException("Todo not found"));

        return ResponseEntity.ok(todo);
    }

    @PostMapping("/create")
    public Todo createTodo(@RequestBody Todo todo) {
        //log.info("createTodo {}", todo.toString());
        return todoService.creatTodo(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id,todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodos(id);
        return ResponseEntity.ok().build();
    }
}
