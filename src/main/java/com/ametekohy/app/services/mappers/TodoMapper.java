package com.ametekohy.app.services.mappers;

import com.ametekohy.app.services.dtos.TodoDto;
import com.google.gson.Gson;

public class TodoMapper {

    private Gson gson;

    public TodoMapper() {
        gson = new Gson();
    }

    public TodoDto[] mapToJava(String json) {
        TodoDto[] todoDtos = gson.fromJson(json, TodoDto[].class);
        return todoDtos;
    }

    public String mapToJson(TodoDto dto) {
        String json = gson.toJson(dto);
        return json;
    }
}
