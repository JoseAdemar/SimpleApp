package com.simpleapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleapp.api.model.Todo;
import com.simpleapp.api.service.TodoService;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@PostMapping //Controller para salvar um todo
	public ResponseEntity<?> saveTodo(@RequestBody Todo todo) {

		Todo saveTodo = todoService.Savetodo(todo);
		return ResponseEntity.status(HttpStatus.OK).body(saveTodo);

	}
	
	@GetMapping("/{id}") //Controller para buscar todo por ID
	public ResponseEntity<?> findTodoById(@PathVariable Long id){
		
		Todo findTodoById = todoService.findTodoById(id);
		return ResponseEntity.status(HttpStatus.OK).body(findTodoById);
		
	}
	
	@GetMapping //Controller lista tudo
	public ResponseEntity<?> listAllTodo(){
	      List<Todo> listAll = todoService.listAllTodo();
	      return ResponseEntity.status(HttpStatus.OK).body(listAll);
	}
	
	@DeleteMapping("/{id}") //Controller para deletar uma tarefa
	public ResponseEntity<?> deleteTodo(@PathVariable Long id){
		Todo deleteTodoById = todoService.deleteTodo(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleteTodoById);
	}
	
	@PatchMapping("/{id}/done")  //Controller para fazer um patch em done
	public ResponseEntity<?> markDone(@PathVariable Long id){
		
		Todo todo = todoService.markAsDone(id);
		return ResponseEntity.status(HttpStatus.OK).body(todo);
		
	}
}
