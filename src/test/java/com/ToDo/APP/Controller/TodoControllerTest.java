package com.ToDo.APP.Controller;

import com.ToDo.APP.Model.Dto.AddTodoDto;
import com.ToDo.APP.Model.Dto.TodoDto;
import com.ToDo.APP.Model.Dto.UpdateTodoDto;
import com.ToDo.APP.Model.Entity.Todo;
import com.ToDo.APP.Service.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = TodoController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class TodoControllerTest {

    @MockBean
    private TodoService todoService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private TodoDto todoDto;
    private AddTodoDto addTodoDto;
    private UpdateTodoDto updateTodoDto;
    private Todo todo;
    @BeforeEach
    public void init(){
        todo=Todo.builder().title("run").description("run 8 km").timestamp(System.currentTimeMillis()).build();
        todoDto=TodoDto.builder().title("run").description("run 8 km").timestamp(System.currentTimeMillis()).build();;
        addTodoDto= AddTodoDto.builder().title("run").description("run 8 km").timestamp(System.currentTimeMillis()).build();
        updateTodoDto= UpdateTodoDto.builder().title("run").description("run 8 km").timestamp(System.currentTimeMillis()).build();
    }
    @Test
    public void ControllerTodo_get_ReturnTodoDto()throws Exception{
        Long id =4l;
        when(todoService.get(id)).thenReturn(todoDto);
        ResultActions response =mockMvc.perform(MockMvcRequestBuilders.get("/4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(todoDto)))
                         .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is(todoDto.getTitle())))
                         .andExpect(MockMvcResultMatchers.status().isOk());
    }
     @Test
    public void ControllerTodo_getAll_ReturnlistofTodoDto() throws Exception{
         List<TodoDto> todos = Arrays.asList(todoDto);
        when(todoService.getAll()).thenReturn(todos);
        ResultActions response =mockMvc.perform(MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todos)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", CoreMatchers.is(todoDto.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description",CoreMatchers.is(todoDto.getDescription())));
    }
    @Test
    public void ControllerTodo_SAVE_ReturnTodoDto()throws Exception{
        when(todoService.save(addTodoDto)).thenReturn(todoDto);
        ResultActions response =mockMvc.perform(MockMvcRequestBuilders.post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(todoDto)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is(todoDto.getTitle())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    public void ControllerTodo_UPDATE_ReturnTodoDto()throws Exception{
        when(todoService.update(updateTodoDto)).thenReturn(todoDto);
        ResultActions response =mockMvc.perform(MockMvcRequestBuilders.put("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(todoDto)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is(todoDto.getTitle())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    public void ControllerTodo_delete_ReturnTodoDto()throws Exception{
        Long id=1l;
        when(todoService.delete(id)).thenReturn(anyString());
        ResultActions response =mockMvc.perform(MockMvcRequestBuilders.delete("/?id=1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todoDto)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }


}
