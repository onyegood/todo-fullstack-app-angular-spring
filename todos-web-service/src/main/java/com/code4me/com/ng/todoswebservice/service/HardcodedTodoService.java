package com.code4me.com.ng.todoswebservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.code4me.com.ng.todoswebservice.model.Todo;

@Service
public class HardcodedTodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "onyegood", "learn prodramming", new Date(), true));
		todos.add(new Todo(++idCounter, "onyegood", "learn microservice", new Date(), true));
		todos.add(new Todo(++idCounter, "onyegood", "learn angular", new Date(), false));
		todos.add(new Todo(++idCounter, "onyegood", "learn HTML", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(Long id) {
		Todo todo = this.findById(id);
		
		if(todo == null) return null;
		
		if(todos.remove(todo)){
			return todo;
		}
		
		return null;
	}

	public Todo findById(Long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			deleteById(todo.getId());
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

}
