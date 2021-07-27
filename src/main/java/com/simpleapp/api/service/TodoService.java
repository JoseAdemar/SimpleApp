package com.simpleapp.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.simpleapp.api.model.Todo;
import com.simpleapp.api.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	// Metodo salvar
	public Todo Savetodo(Todo todo) {

		return todoRepository.save(todo);
	}

	// Busca um todo por ID
	public Todo findTodoById(Long id) {

		return todoRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException("ID não encontrado", 0));

	}

	// Lista todos
	public List<Todo> listAllTodo() {
		return todoRepository.findAll();
	}

	// Metodo para deletar
	public Todo deleteTodo(Long id) {

		Todo todo = todoRepository.findById(id).get();
		if (todo != null) {
			todoRepository.deleteById(todo.getId());
		}

		return todo;
	}
	
	//Metodo para colocar uma tarefa como concluída
	public Todo markAsDone(Long id) {
		
		return todoRepository.findById(id).map(todo -> {
			todo.setDone(true);
			todo.setDoneDate(LocalDateTime.now());
			todoRepository.save(todo);
			return todo;
		}).orElse(null);
	}
}
