package com.code4me.com.ng.todoswebservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.code4me.com.ng.todoswebservice.model.Todo;
import com.code4me.com.ng.todoswebservice.service.HardcodedTodoService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/users")
public class TodoController {

	@Autowired
	private HardcodedTodoService todoService;

	@GetMapping("/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoService.findAll();
	}

	@GetMapping("/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable Long id) {
		return todoService.findById(id);
	}

	@DeleteMapping("/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodos(@PathVariable String username, @PathVariable Long id) {
		Todo todo = todoService.deleteById(id);
		if (todo != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodos(@PathVariable String username, @PathVariable Long id,
			@RequestBody Todo todo) {
		Todo updatedTodo = todoService.save(todo);

		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
	}

	@PostMapping("/{username}/todos")
	public ResponseEntity<Todo> createTodos(@PathVariable String username, @RequestBody Todo todo) {
		Todo createdTodo = todoService.save(todo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
