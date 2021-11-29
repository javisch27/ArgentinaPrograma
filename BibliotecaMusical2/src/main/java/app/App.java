package app;

import dao.AutorDAO;
import dao.CancionDAO;
import dao.DAOFactory;


public class App {

	public static void main(String[] args) {
		AutorDAO autorDAO = DAOFactory.getAutorDAO();
		CancionDAO cancionDAO = DAOFactory.getCancionDAO();
		
		System.out.println("Autores");
		System.out.println(autorDAO.countAll());
		System.out.println(autorDAO.findAll());

		System.out.println("Canciones");
		System.out.println(cancionDAO.countAll());
		System.out.println(cancionDAO.findAll());
		
		System.out.println("Cancion 1");
		System.out.println(cancionDAO.buscarPorNombre("Cancion 1"));
		
		System.out.println("Cancion No existente");
		System.out.println(cancionDAO.buscarPorNombre("Cancion No existente"));
	}

}
