package br.com.cotiinformatica.controllers;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.TarefaPostRequest;
import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.enums.Prioridade;
import br.com.cotiinformatica.repositories.TarefaRepository;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {
	
	private TarefaRepository tarefaRepository = new TarefaRepository();

	@PostMapping
	public ResponseEntity<?> post(@RequestBody TarefaPostRequest request) {
		
			var tarefa = new Tarefa();
			
			tarefa.setId(UUID.randomUUID());;
			tarefa.setNome(request.getNomeTarefa());
			tarefa.setData(LocalDate.parse(request.getDataTarefa()));
			tarefa.setPrioridade(Prioridade.valueOf(request.getPrioridadeTarefa()));
			tarefa.setFinalizado(false);
			
			tarefa.setCategoria(new Categoria());
			tarefa.getCategoria().setId(UUID.fromString(request.getCategoriaIdTarefa()));;
			
			tarefaRepository.insert(tarefa);
			
			return ResponseEntity.ok("Tarefa cadastrado com sucesso!");
		
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
