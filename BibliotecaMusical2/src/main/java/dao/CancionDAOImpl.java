package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.*;

public class CancionDAOImpl implements CancionDAO {

	public Cancion buscarPorNombre(String titulo) {
		try {
			String sql = "SELECT * FROM \"canciones\" WHERE \"titulo\" = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, titulo);
			ResultSet resultados = statement.executeQuery();

			Cancion cancion = null;

			if (resultados.next()) {
				cancion = toCancion(resultados);
			}

			return cancion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT count(*) AS 'total' FROM canciones";
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

	public List<Cancion> findAll() {
		try {
			String sql = "SELECT * FROM \"canciones\"";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Cancion> canciones = new LinkedList<Cancion>();
			while (resultados.next()) {
				canciones.add(toCancion(resultados));
			}

			return canciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Cancion toCancion(ResultSet resultados) throws SQLException {
		return new Cancion(resultados.getInt("id"), resultados.getString("titulo"), resultados.getInt("fk_autor"),
				resultados.getInt("duracion"), resultados.getString("genero"));
	}
	
	public int insert(Cancion cancion) {
		try {
			String sql = "INSERT INTO \"canciones\" (ID, TITULO, FK_AUTOR, DURACION, GENERO) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, cancion.getId());
			statement.setString(2, cancion.getNombre());
			statement.setInt(3, cancion.getFk_autor());
			statement.setInt(4, cancion.getDuracion());
			statement.setString(5, cancion.getGenero());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Cancion cancion) {
		try {
			String sql = "UPDATE \"canciones\" SET TITULO = ? SET FK_AUTOR = ? SET DURACION = ? SET GENERO = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cancion.getNombre());
			statement.setInt(2, cancion.getFk_autor());
			statement.setInt(3, cancion.getDuracion());
			statement.setString(4, cancion.getGenero());
			statement.setInt(5, cancion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int delete(Cancion cancion) {
		try {
			String sql = "DELETE FROM \"canciones\" WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, cancion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
