/*	PRACTICA 3 MASTER AVANZADO JEE
 * 	Jorge Aguado
 */
package app.negocio;

import java.util.List;
import app.modelo.*;
import app.persistencia.ItfzLibrosDao;

// TODO: Auto-generated Javadoc
/**
 * The Class GestionLibreria.
 */
public class GestionLibreria implements ItfzGestionLibreria {

	/** The dao. */
	private ItfzLibrosDao dao;// Interfaz instanciada con un objeto desde
								// spring.xml

	/**
	 * Alta libro.
	 *
	 * @param libro
	 *            the libro
	 */
	public void altaLibro(Libro libro) {
		boolean altaLibro = false;
		// En caso de excepcion en la capa de persistencia
		// evitamos que se transmita al main ya que de este modo no se
		// interrumpe el menu principal
		altaLibro = dao.altaLibro(libro);
		// Si se ha realizado el alta correctamente
		if (altaLibro == true)
			System.out.println("Libro con ISBN "
					+ libro.getIsbn() +" insertado correctamente");
		else
			System.out.println("No ha sido posible insertar libro con ISBN " + libro.getIsbn() );

	}

	/**
	 * Eliminar libro.
	 *
	 * @param ISBN
	 *            the isbn
	 */
	public void eliminarLibro(String ISBN) {

		boolean eliminado = false; // En caso de excepcion en la capa de
									// persistencia
		// evitamos que se transmita al main ya que de este modo no se
		// interrumpe el menu principal

		eliminado = dao.eliminarLibro(ISBN);

		if (eliminado == true)
			System.out.println("Libro con ISBN " + ISBN + " eliminado");
		else
			System.out.println("Libro con ISBN " + ISBN
					+ " no ha sido eliminado");

	}

	/**
	 * Consultar todos.
	 */
	public void consultarTodos() {

		List<Libro> libros = null; // En caso de excepcion en la capa de
									// persistencia
		// evitamos que se transmita al main ya que de este modo no se
		// interrumpe el menu principal

		libros = dao.consultarTodos();

		if (libros != null) // Imprimimos todos los libros usando el metodo
							// sobreescrito
			for (Libro lib : libros)
				// toString
				System.out.println(lib);

	}

	/**
	 * Consultar isbn.
	 *
	 * @param isbn
	 *            the isbn
	 */
	public void consultarISBN(String isbn) {

		Libro lib = null; // En caso de excepcion en la capa de persistencia
		// evitamos que se transmita al main ya que de este modo no se
		// interrumpe el menu principal

		lib = dao.consultarISBN(isbn);

		if (lib != null)// Si no nulo, el isbn esta en la BBDD
			System.out.println(lib);
		else
			System.out
					.println("No ha sido posible encontrar el libro con ISBN "
							+ isbn);

	}

	/**
	 * Consultar titulo.
	 *
	 * @param titulo
	 *            the titulo
	 */
	public void consultarTitulo(String titulo) {

		List<Libro> listLibros = null; // En caso de excepcion en la capa de
										// persistencia
		// evitamos que se transmita al main ya que de este modo no se
		// interrumpe el menu principal
		try {
			listLibros = dao.consultarTitulo(titulo);// Puede haber mas de una
			// entrada con el mismo titulo

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		if (listLibros != null)// Si hay por lo menos una
			for (Libro lib : listLibros)
				System.out.println(lib);
		else
			System.out
					.println("No ha sido posible encontrar ningún libro con titulo "
							+ titulo);

	}

	/**
	 * Modificar precio.
	 *
	 * @param isbn
	 *            the isbn
	 * @param precio
	 *            the precio
	 */
	public void modificarPrecio(String isbn, double precio) {

		boolean modificado = true; // En caso de excepcion en la capa de
									// persistencia
		// evitamos que se transmita al main ya que de este modo no se
		// interrumpe el menu principal

		modificado = dao.modificarPrecio(isbn, precio);

		if (modificado == true)// Si encontrado isbn
			System.out.println("Modificado el precio del libro con Isbn "
					+ isbn);
		else
			System.out
					.println("No ha sido posible modificar el precio del libro con Isbn "
							+ isbn);

	}

	/**
	 * Gets the dao.
	 *
	 * @return the dao
	 */
	public ItfzLibrosDao getDao() {
		return dao;
	}

	/**
	 * Sets the dao.
	 *
	 * @param dao
	 *            the new dao
	 */
	public void setDao(ItfzLibrosDao dao) {
		this.dao = dao;
	}

}
