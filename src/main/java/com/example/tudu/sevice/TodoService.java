package com.example.tudu.sevice;

import com.example.tudu.entity.TodoEntity;
import com.example.tudu.entity.UserEntity;
import com.example.tudu.exceptions.UserNotFoundException;
import com.example.tudu.model.Todo;
import com.example.tudu.repository.TodoRepo;
import com.example.tudu.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
