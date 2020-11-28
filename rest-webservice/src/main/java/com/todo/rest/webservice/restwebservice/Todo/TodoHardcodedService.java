package com.todo.rest.webservice.restwebservice.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	private static int idCounter = 0;
	
	public static List <Todo> todo = new ArrayList<>();
	
	static {
		todo.add(new Todo(++idCounter, "Michael", "Learn Java Better", new Date(), false ));
		todo.add(new Todo(++idCounter, "Michael", "Get groceries", new Date(), false ));
		todo.add(new Todo(++idCounter, "Michael", "Visit Atlanta", new Date(), false ));
	}
	public List <Todo> findAll() {
		return todo;
	}
	public Todo save(Todo todos) {
		if(todos.getId() == -1 || todos.getId() == 0) {
			todos.setId(++idCounter);
			todo.add(todos);
		} else {
			deleteById(todos.getId());
			todo.add(todos);
		}
		return todos;
	}
	public Todo deleteById(long id) {
		Todo todos = findById(id);
		if (todos == null) {
			return null;
			}
			if(todo.remove(todos)) {
				return todos;
			}
		return null;
	}
	public Todo findById(long id) {
		for(Todo todos:todo)
			if(todos.getId() == id) {
				return todos;
			}
		return null;
	}

}