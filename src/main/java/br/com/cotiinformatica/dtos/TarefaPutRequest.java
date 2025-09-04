package br.com.cotiinformatica.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TarefaPutRequest {
	
	private String nomeTarefa;
	private String dataTarefa;
	private String prioridadeTarefa;
	private String finalizadoTarefa;
	private String categoriaIdTarefa;

}
