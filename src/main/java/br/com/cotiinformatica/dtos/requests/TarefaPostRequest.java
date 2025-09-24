package br.com.cotiinformatica.dtos.requests;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TarefaPostRequest {
	
	private String nomeTarefa;
	private String dataTarefa;
	private String prioridadeTarefa;
	private String categoriaIdTarefa;
}
