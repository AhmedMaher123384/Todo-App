package com.ToDo.APP.Model.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoDto {

    private Long id;
    private String title;
    private String description;
    private Long timestamp ;
}
