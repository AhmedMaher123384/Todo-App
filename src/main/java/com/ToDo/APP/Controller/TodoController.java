package com.ToDo.APP.Controller;

import com.ToDo.APP.Model.Dto.AddTodoDto;
import com.ToDo.APP.Model.Dto.TodoDto;
import com.ToDo.APP.Model.Dto.UpdateTodoDto;
import com.ToDo.APP.Service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(todoService.get(id), HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<TodoDto>> getAll() {
        return new ResponseEntity<>(todoService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<TodoDto> save(@Valid @RequestBody AddTodoDto addTodoDto) {
    return new ResponseEntity<>(todoService.save(addTodoDto), HttpStatus.CREATED);
    }
    @PutMapping("/")
    public ResponseEntity<TodoDto> update(@RequestBody UpdateTodoDto updateTodoDto) {
        return new ResponseEntity<>(todoService.update(updateTodoDto), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(todoService.delete(id), HttpStatus.OK);
    }
 }
