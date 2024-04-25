package com.selflearnining.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;


@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "kevin", "Learn AWS", LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "kevin", "Learn DevOps", LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount, "kevin", "Learn FullStack Development", LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount, "kevin", "Learn Generative AI", LocalDate.now().plusYears(2),false));

	}

	public  List<Todo> findByUsername(String username) {
		return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		todos.add(new Todo(++todosCount, username, description, targetDate,done));
		
	}
	
	public void deleteById(int id) {
		todos.removeIf(todo -> todo.getId() == id);
	}

	public Todo findById(int id) {
		// TODO Auto-generated method stub
		return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}


	
	
}
