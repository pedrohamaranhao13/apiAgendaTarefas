package br.com.cotiinformatica.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class CategoriaRepository {

private ConnectionFactory connectionFactory = new  ConnectionFactory(); 
	
	@GetMapping
	public List<Categoria> findAll() {
		
		try {
			
			//Abrindo conexão com o banco de dados
			var connection = connectionFactory.getConnection();
			
			// Escreber o camando SQL que será executado 
			var  sql = """
							select id, nome from categoria order by nome
						""";
			
			//Executar o comando sql no banco de dados e capturar a resposta
			var statement = connection.prepareStatement(sql);
			var result = statement.executeQuery();
			
			//criando uma lista de categoria vazia
			var lista = new ArrayList<Categoria>();
					
			//Ler cada registro obtido do bd
			while(result.next()) {
				
				//Criando um ojeto da classe Categoria
				var categoria = new Categoria();
				
				//preenchendo o objeto da classe Categoria com os valores dos campos que estamos lendo da tabela do banco
				categoria.setId(UUID.fromString(result.getString("id")));
				categoria.setNome(result.getString("nome"));
				
				lista.add(categoria);
				//adicionando o objeto na lista
			}
			
			// fechando a conexãao do banco de dados
			connection.close();
			
			//retornando a lista de categorias
			return lista;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
