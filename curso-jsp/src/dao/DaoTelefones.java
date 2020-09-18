package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanTelefones;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import connection.SingleConnection;

public class DaoTelefones {

	// instacia a conexão com o banco
	private Connection connection;

	//conecta com o banco
	public DaoTelefones() {
		connection = SingleConnection.getConnection();
	}

	// metodo para salvar
	public void salvar(BeanTelefones telefones) {

		try {
			String sql = "INSERT INTO telefone (numero, tipo, usuario) VALUES(?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, telefones.getNumero());
			insert.setString(2, telefones.getTipo());
			insert.setLong(3, telefones.getUsuario());
			insert.execute();

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

	// metodo para listar produto
	public List<BeanTelefones> listar(Long user) throws Exception {

		
		List<BeanTelefones> listar = new ArrayList<BeanTelefones>();

		String sql = "SELECT * FROM telefone WHERE usuario = " + user;

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			BeanTelefones beanTelefones = new BeanTelefones();
			beanTelefones.setId(resultSet.getLong("id"));
			beanTelefones.setNumero(resultSet.getString("numero"));
			beanTelefones.setTipo(resultSet.getString("tipo"));
			beanTelefones.setUsuario(resultSet.getLong("usuario"));

			listar.add(beanTelefones);
		}

		return listar;

	}

	//metodo para deletar produto
	public void deletar(String id) {

		try {
			String sql = "DELETE FROM telefone WHERE id = '" + id + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	
		// metodo que atualiza produto
	public void atualizar(BeanTelefones telefones) {

		try {
			String sql = "UPDATE telefone SET numero = ?, tipo = ?, usuario = ? WHERE id = " + telefones.getId();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, telefones.getNumero());
			statement.setString(2, telefones.getTipo());
			statement.setLong(3, telefones.getUsuario());
			statement.executeUpdate();
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
}
