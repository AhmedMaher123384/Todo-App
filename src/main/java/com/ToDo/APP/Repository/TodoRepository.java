package com.ToDo.APP.Repository;

import com.ToDo.APP.Model.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
