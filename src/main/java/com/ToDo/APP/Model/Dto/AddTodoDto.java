package com.ToDo.APP.Model.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddTodoDto {
    @NotNull(message = "Title is required")
    @Size(min = 3, message = "Title must be at least 3 characters long")
    private String title;
    @NotNull(message = "Description is required")
    private String description;
    private Long timestamp ;
}

