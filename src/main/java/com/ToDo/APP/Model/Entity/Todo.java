package com.ToDo.APP.Model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "TimeStamp")
    private Long timestamp;

}
