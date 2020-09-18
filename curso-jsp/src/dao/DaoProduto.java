package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCategoria;
import beans.BeanProduto;
import connection.SingleConnection;

public class DaoProduto {
	
	//instacia conexãocom o bando de dados
	private Connection connection;
	
	public DaoProduto(){
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(BeanProduto produto) {
		
		try{
		String sql = "INSERT INTO produto (descricao, quantidade, valor, categoria_id) VALUES(?, ?, ?, ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, produto.getDescricao());
		insert.setDouble(2, produto.getQuantidade());
		insert.setDouble(3, produto.getValor());
		insert.setLong(4, produto.getCategoria_id());
		insert.execute();
		
		connection.commit();
		
		} catch (Exception e){
			e.printStackTrace();			
		}
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<BeanProduto> listar() throws Exception {
		List<BeanProduto> listar = new ArrayList<BeanProduto>();
		
		String sql = "SELECT * FROM produto";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()){
			BeanProduto beanProduto = new BeanProduto();
			beanProduto.setId(resultSet.getLong("id"));
			beanProduto.setDescricao(resultSet.getString("descricao"));
			beanProduto.setQuantidade(resultSet.getDouble("quantidade"));
			beanProduto.setValor(resultSet.getDouble("valor"));
			beanProduto.setCategoria_id(resultSet.getLong("categoria_id"));
			listar.add(beanProduto);
		}
		return listar;
		
	}
	
	public List<BeanCategoria> listaCategoria() throws Exception {
		List<BeanCategoria> retorno = new ArrayList<BeanCategoria>();
		String sql = "SELECT * FROM categoria";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()){
			BeanCategoria categoria = new BeanCategoria();
			categoria.setId(resultSet.getLong("id"));
			categoria.setNome(resultSet.getString("nome"));
			retorno.add(categoria);
		}
		return retorno;
	}
	
	public void delete(String id){
		
		try {
		String sql = "DELETE FROM produto WHERE id = '" + id + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BeanProduto consultar(String id) throws Exception {
		
		String sql = "SELECT * FROM produto WHERE id = '" + id +"'";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet .next()){
			BeanProduto beanProduto = new BeanProduto();
			beanProduto.setId(resultSet.getLong("id"));
			beanProduto.setDescricao(resultSet.getString("descricao"));
			beanProduto.setQuantidade(resultSet.getDouble("quantidade"));
			beanProduto.setValor(resultSet.getDouble("valor"));
			beanProduto.setCategoria_id(resultSet.getLong("categoria_id"));
			return beanProduto;
		}
			return null;
		
	}
	
	public boolean validarDescricao(String descricao)throws Exception {
		
		String sql = "SELECT COUNT(1) AS qtde FROM produto WHERE descricao = '" + descricao +"'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet =  statement.executeQuery();
			if (resultSet.next()){
				return resultSet.getInt("qtde") <= 0;
			}
			return false;
	}
	
	public void atualizar(BeanProduto produto){
		
		try {
		String sql = "UPDATE produto SET descricao = ?, quantidade = ?, valor = ?, categoria_id = ? WHERE id = " + produto.getId();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, produto.getDescricao());
		statement.setDouble(2, produto.getQuantidade());
		statement.setDouble(3, produto.getValor());
		statement.setLong(4, produto.getCategoria_id());	

		connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
