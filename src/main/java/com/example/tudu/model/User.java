package com.example.tudu.model;

import com.example.tudu.entity.TodoEntity;
import com.example.tudu.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String username;
    private List<Todo> todos;

    public static User toModel(UserEntity user) {
        User model = new User(user.getId(), user.getUsername());
        List<TodoEntity> todoEntities = user.getTodos();
        List<Todo> todos = new ArrayList<>();
        for (int i = 0; i < todoEntities.size(); i++) {
            todos.add(Todo.toModel(todoEntities.get(i)));
        }
        model.setTodos(todos);
        return model;
    }

    public User() {
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
