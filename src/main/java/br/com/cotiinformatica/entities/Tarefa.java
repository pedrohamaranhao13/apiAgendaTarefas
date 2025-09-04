package br.com.cotiinformatica.entities;

import java.time.LocalDate;
import java.util.UUID;

import br.com.cotiinformatica.enums.Prioridade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tarefa {

	private UUID id;
	private String nome;
	private LocalDate data;
	private Prioridade prioridade;
	private Boolean finalizado;
	private Categoria categoria;
	
}
