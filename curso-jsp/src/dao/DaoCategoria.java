package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.BeanCategoria;
import connection.SingleConnection;

public class DaoCategoria {

	private Connection connection;

	public DaoCategoria() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(BeanCategoria categoria) {

		try {
			String sql = "INSERT INTO categoria (nome) VALUES (?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, categoria.getNome());
			insert.execute();

			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connection.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void atualizar(BeanCategoria categoria) {

		try {
			String sql = "UPDATE categoria SET nome=? WHERE id = "
					+ categoria.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, categoria.getNome());

			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {

		try {
			String sql = "SELECT * FROM categoria WHERE id = '" + id + "'";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
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

}
