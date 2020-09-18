package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import bean.BeanUsuario;
import connection.SingleConnection;
import entidades.Usuario;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	
	
	public List<Usuario> getUsuarios() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM usuario";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()){
		Usuario usuario = new Usuario();
		
		usuario.setId(resultSet.getString("id"));
		usuario.setLogin(resultSet.getString("login"));
		usuario.setBairro(resultSet.getString("bairro"));
		usuario.setEstado(resultSet.getString("estado"));
		//usuario.setImagem(resultSet.getString("imagem"));
		usuarios.add(usuario);	
		}
		return usuarios;
	}
	
	public void delete(String id) {

		try {
			String sql = "DELETE FROM usuario WHERE id = '" + id + "' and login <> 'admin'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();

			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	
	public boolean validarLogin(String login) throws Exception {
		String sql = "SELECT count(1) as quant FROM usuario where login = '" + login + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			

			return resultSet.getInt("quant") <= 0; //retorno verdadeiro
		}
		return false;
	}
	
	
	public boolean validarLoginBcoUpdate(String login, String id) throws Exception {
		String sql = "SELECT COUNT(1) AS quant FROM usuario WHERE login = '" + login + "' AND id <> " + id;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return resultSet.getInt("quant") <= 0; //retorno verdadeiro
		}
		return false;
	}
	
	public boolean validarSenha(String senha) throws Exception{
		String sql = "SELECT COUNT(1) AS quant FROM usuario WHERE senha = '" + senha +"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			return resultSet.getInt("quant") <= 0;
		}
		return false;	
	}
	

	public void gravarImagem(String imagem) throws SQLException {
		
		String tipoDado = imagem.split(",")[0].split(";")[0].split("/")[1];
		
		String sql = "INSERT INTO usuario (imagem, tipofile) VALUES(?, ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, imagem);
		insert.setString(2, tipoDado);
		insert.execute();
		connection.commit();
		
	}


	public BeanUsuario buscarImagem(String iduser) {
		
		try{
		String sql = "SELECT * FROM usuario WHERE id = " + iduser;
		
		PreparedStatement buscaImagem = connection.prepareStatement(sql);
		ResultSet resultSet = buscaImagem.executeQuery();
		
		while(resultSet.next()){
			
			BeanUsuario usuario = new BeanUsuario();
			usuario.setId(resultSet.getLong("id"));
			usuario.setLogin(resultSet.getString("login"));
			usuario.setImagem(resultSet.getString("imagem"));
			usuario.setTipofile(resultSet.getString("tipofile"));
			
			return usuario;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
