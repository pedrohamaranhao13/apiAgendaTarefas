package br.com.cotiinformatica.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.repositories.CategoriaRepository;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
	
	private CategoriaRepository categoriaRepository = new CategoriaRepository();
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		
		try {
			var lista = categoriaRepository.findAll();
			
			return ResponseEntity.status(200).body(lista);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	

}
