package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.*;

public class AutorDAOImpl implements AutorDAO {

	public Autor buscarPorNombre(String nombre) {
		try {
			String sql = "SELECT * FROM \"autores\" WHERE \"nombre\" = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Autor autor = null;

			if (resultados.next()) {
				autor = toAutor(resultados);
			}

			return autor;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT count(1) AS 'total' FROM \"autores\"";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("total");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Autor> findAll() {
		try {
			String sql = "SELECT * FROM \"autores\"";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Autor> autores = new LinkedList<Autor>();
			while (resultados.next()) {
				autores.add(toAutor(resultados));
			}

			return autores;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Autor toAutor(ResultSet resultados) throws SQLException {
		return new Autor(resultados.getInt(1), resultados.getString(2));
	}

	public int insert(Autor autor) {
		try {
			String sql = "INSERT INTO \"autores\" (ID, NOMBRE) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, autor.getId());
			statement.setString(2, autor.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Autor autor) {
		try {
			String sql = "UPDATE \"autores\" SET NOMBRE = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, autor.getNombre());
			statement.setInt(2, autor.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int delete(Autor autor) {
		try {
			String sql = "DELETE FROM \"autores\" WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, autor.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
