package com.ToDo.APP.Service;

import com.ToDo.APP.Exception.NotFoundException;
import com.ToDo.APP.Model.Dto.AddTodoDto;
import com.ToDo.APP.Model.Dto.TodoDto;
import com.ToDo.APP.Model.Dto.UpdateTodoDto;
import com.ToDo.APP.Model.Entity.Todo;
import com.ToDo.APP.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoDto save(AddTodoDto addTodoDto) {
        Todo todo = Todo.builder()
                .description(addTodoDto.getDescription())
                .title(addTodoDto.getTitle())
                .timestamp(System.currentTimeMillis())
                .build();
        Todo entity = todoRepository.save(todo);
        TodoDto todoDto = TodoDto.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .title(entity.getTitle())
                .timestamp(entity.getTimestamp())
                .build();
        return todoDto;
    }

    public TodoDto update(UpdateTodoDto updateTodoDto) {

        Todo todo = Todo.builder()
                .id(updateTodoDto.getId())
                .description(updateTodoDto.getDescription())
                .title(updateTodoDto.getTitle())
                .timestamp(System.currentTimeMillis())
                .build();
        Todo entity = todoRepository.save(todo);
        TodoDto todoDto = TodoDto.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .title(entity.getTitle())
                .timestamp(entity.getTimestamp())
                .build();
        return todoDto;
    }


    public TodoDto get(Long id) {
        Todo todo = this.todoRepository.findById(id).orElseThrow(()->
                    new NotFoundException(String.format("No Record with the id [%s] was found in our database", id)));
        TodoDto todoDto = TodoDto.builder()
                .id(todo.getId())
                .timestamp(todo.getTimestamp())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .build();
        return todoDto;
    }

    public String delete(Long id) {
        todoRepository.deleteById(id);
        return String.format("the todo have id = %s removed ", id);
    }

    public List<TodoDto> getAll() {
        List<Todo> todos = todoRepository.findAll();
        List<TodoDto> todoDtos =todtos(todos);
        return todoDtos;
    }


    public List<TodoDto> todtos(List<Todo> todos) {
    List<TodoDto> DTOS = todos.stream().map(todo -> {
        TodoDto todoDto = TodoDto.builder()
                .id(todo.getId())
                .description(todo.getDescription())
                .title(todo.getTitle())
                .timestamp(todo.getTimestamp())
                .build();
                return todoDto;
        }).collect(Collectors.toList());
    return DTOS;
    }
}
