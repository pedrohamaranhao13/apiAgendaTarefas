package br.com.cotiinformatica.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.enums.Prioridade;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class TarefaRepository {
	
	private ConnectionFactory connectionFactory = new ConnectionFactory();

	
	public void insert(Tarefa tarefa) {

		try {
			
			var connection = connectionFactory.getConnection();
			
			var sql = """
						insert into tarefa(id, nome, data, prioridade, finalizado, categoria_id)  
						values(?,?,?,?,?,?)
					  """;
			
			var statement = connection.prepareStatement(sql);
			statement.setObject(1, tarefa.getId());
			statement.setString(2, tarefa.getNome());
			statement.setDate(3, java.sql.Date.valueOf(tarefa.getData()));
			statement.setString(4, tarefa.getPrioridade().toString());
			statement.setBoolean(5, tarefa.getFinalizado());
			statement.setObject(6, tarefa.getCategoria().getId());
			statement.execute();
			
			connection.close();
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean update(Tarefa tarefa) {

		try {
			
			var connection = connectionFactory.getConnection();
			
			var sql = """
						update tarefa set
							nome = ?, 
							data = ?,
							prioridade= ?,
							finalizado = ?,
							categoria_id = ?  
						 where id = ?
					  """;
			
			var statement = connection.prepareStatement(sql);
			statement.setString(1, tarefa.getNome());
			statement.setDate(2, java.sql.Date.valueOf(tarefa.getData()));
			statement.setString(3, tarefa.getPrioridade().toString());
			statement.setBoolean(4, tarefa.getFinalizado());
			statement.setObject(5, tarefa.getCategoria().getId());
			statement.setObject(6, tarefa.getId());
			var rowsAffected = statement.executeUpdate();
			
			connection.close();
			
			return rowsAffected > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean delete(UUID id) {
		
		try {
			var connection = connectionFactory.getConnection();
			
			var sql = """
						delete from tarefa   
						 where id = ?
					  """;
			
			var statement = connection.prepareStatement(sql);
			statement.setObject(1, id);
			
			var rowsAffected = statement.executeUpdate();
			
			connection.close();
			
			return rowsAffected > 0;	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Tarefa> findAll() {
		
		try {
			
			var connection = connectionFactory.getConnection();
			
			var sql = """
						select id, nome, data, prioridade, finalizado 
						fromm tarefa
						order by data
					  """;
			
			var statement = connection.prepareStatement(sql);
			var result = statement.executeQuery();
			
			var lista = new ArrayList<Tarefa>();
			
			while(result.next()) {
				
				var tarefa = new Tarefa();
				
				tarefa.setId(UUID.fromString(result.getString("id")));
				tarefa.setNome(result.getString("nome"));
				tarefa.setData(LocalDate.parse(result.getString("data")));
				tarefa.setPrioridade(Prioridade.valueOf(result.getString("prioridade")));
				tarefa.setFinalizado(result.getBoolean("finalizado"));
				
				lista.add(tarefa);
				
			}
			
			connection.close();
			
			return lista;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
