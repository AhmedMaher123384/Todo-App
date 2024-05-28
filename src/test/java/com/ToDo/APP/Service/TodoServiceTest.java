import com.ToDo.APP.Model.Dto.AddTodoDto;
import com.ToDo.APP.Model.Dto.TodoDto;
import com.ToDo.APP.Model.Dto.UpdateTodoDto;
import com.ToDo.APP.Model.Entity.Todo;
import com.ToDo.APP.Repository.TodoRepository;
import com.ToDo.APP.Service.TodoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    private TodoDto todoDto;
    private AddTodoDto addTodoDto;
    private Todo todo;
    private UpdateTodoDto updateTodoDto;

    @BeforeEach
    public void init() {
        todo = Todo.builder().id(1L).title("run").description("run 8 km").build();
        todoDto = TodoDto.builder().id(1L).title("run").description("run 8 km").build();
        addTodoDto = AddTodoDto.builder().title("run").description("run 8 km").build();
        updateTodoDto=UpdateTodoDto.builder().title("run").description("run 8 km").build();
    }

    @Test
    public void BookService_get_ReturnTodoDto() {
        Long id = 1L;
        when(todoRepository.findById(id)).thenReturn(Optional.of(todo));
        Assertions.assertThat(todoService.get(id)).isEqualTo(todoDto);
    }

    @Test
    public void BookService_save_ReturnTodoDto() {
        when(todoRepository.save(any(Todo.class))).thenReturn(todo);
        Assertions.assertThat(todoService.save(addTodoDto)).isEqualTo(todoDto);
    }

    @Test
    public void BookService_update_ReturnTodoDto() {
        when(todoRepository.save(any(Todo.class))).thenReturn(todo);
        Assertions.assertThat(todoService.update(updateTodoDto)).isEqualTo(todoDto);
    }
    @Test
    public void testDeleteById() {
        long todoId = 1L;
        doNothing().when(todoRepository).deleteById(anyLong());
        todoService.delete(todoId);
        verify(todoRepository, times(1)).deleteById(todoId);
    }
    @Test
    public void BookService_getAll_ReturnTodoDto() {
        Long id = 1L;
        List<Todo> todos = Arrays.asList(todo);
        List<TodoDto> dtos = Arrays.asList(todoDto);
        when(todoRepository.findAll()).thenReturn(todos);
        Assertions.assertThat(todoService.getAll()).isEqualTo(dtos);
    }
}