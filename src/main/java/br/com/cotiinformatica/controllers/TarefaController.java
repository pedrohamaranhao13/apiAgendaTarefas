package br.com.cotiinformatica.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {

	@PostMapping
	public ResponseEntity<?> post() {
		return ResponseEntity.ok("Sucesso");
	}
	
	@PutMapping
	public ResponseEntity<?> put() {
		return ResponseEntity.ok("Sucesso");
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete() {
		return ResponseEntity.ok("Sucesso");
	}
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok("Sucesso");
	}
}
