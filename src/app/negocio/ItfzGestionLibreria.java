/*	PRACTICA 3 MASTER AVANZADO JEE
 * 	Jorge Aguado
 */
package app.negocio;

import java.util.List;

import app.modelo.Libro;
import app.persistencia.ItfzLibrosDao;

// TODO: Auto-generated Javadoc
/**
 * The Interface ItfzGestionLibreria.
 */
public interface ItfzGestionLibreria {

	/**
	 * Alta libro.
	 *
	 * @param libro
	 *            the libro
	 */
	public void altaLibro(Libro libro);

	/**
	 * Eliminar libro.
	 *
	 * @param ISBN
	 *            the isbn
	 */
	public void eliminarLibro(String ISBN);

	/**
	 * Consultar todos.
	 *
	 * @return the list
	 */
	public void consultarTodos();
	/**
	 * Consultar isbn.
	 *
	 * @param isbn
	 *            the isbn
	 */
	public void consultarISBN(String isbn);

	/**
	 * Consultar titulo.
	 *
	 * @param titulo
	 *            the titulo
	 */
	public void consultarTitulo(String titulo);
	/**
	 * Modificar precio.
	 *
	 * @param isbn
	 *            the isbn
	 * @param precio
	 *            the precio
	 */
	public void modificarPrecio(String isbn, double precio);
	
	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public ItfzLibrosDao getDao();
	
	/**
	 * Sets the dao.
	 *
	 * @param dao
	 *            the new dao
	 */
	public void setDao(ItfzLibrosDao dao);
	
}
