package com.ametekohy.app.services;

import com.ametekohy.app.services.dtos.TodoDto;
import com.ametekohy.app.services.mappers.TodoMapper;

import java.util.function.Consumer;

public class JsonPlaceholderService {

    private TodoMapper todoMapper;

    public JsonPlaceholderService() {
        todoMapper = new TodoMapper();
    }

    public void getTodos() {

    }

    public void getTodosWithCallback(Consumer<String> callback) {

    }

    public void createNewTodoItemOnServer(Consumer<String> callback) {

    }

    private TodoDto createNewTodoItem(int id) {
        var todo = new TodoDto();
        todo.setId(id);
        todo.setCompleted(false);
        todo.setTitle("Finish the DEA Exercise");
        todo.setUserId(2);
        return todo;
    }
}
