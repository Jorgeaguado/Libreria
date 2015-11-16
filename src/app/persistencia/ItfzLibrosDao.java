/*	PRACTICA 3 MASTER AVANZADO JEE
 * 	Jorge Aguado
 */
package app.persistencia;

import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import app.modelo.Libro;

// TODO: Auto-generated Javadoc
/**
 * The Interface ItfzLibrosDao.
 */
public interface ItfzLibrosDao {

	/**
	 * Alta libro.
	 *
	 * @param libro
	 *            the libro
	 * @return true, if successful
	 */
	public boolean altaLibro(Libro libro);

	/**
	 * Eliminar libro.
	 *
	 * @param ISBN
	 *            the isbn
	 * @return true, if successful
	 */
	public boolean eliminarLibro(String ISBN);

	/**
	 * Consultar todos.
	 *
	 * @return the list
	 */
	public List<Libro> consultarTodos();

	/**
	 * Consultar isbn.
	 *
	 * @param isbn
	 *            the isbn
	 * @return the libro
	 */
	public Libro consultarISBN(String isbn);

	/**
	 * Consultar titulo.
	 *
	 * @param titulo
	 *            the titulo
	 * @return the list
	 */
	public List<Libro> consultarTitulo(String titulo);

	/**
	 * Modificar precio.
	 *
	 * @param isbn
	 *            the isbn
	 * @param precio
	 *            the precio
	 * @return true, if successful
	 */
	public boolean modificarPrecio(String isbn, double precio);

	/**
	 * Encuentra libro isbn.
	 *
	 * @param isbn
	 *            the isbn
	 * @throws LibroNoEncontradoException
	 *             the libro no encontrado exception
	 */
//	public void encuentraLibroIsbn(String isbn)
//			throws LibroNoEncontradoException;

	/**
	 * Gets the mapeador producto.
	 *
	 * @return the mapeador producto
	 */
//	public RowMapper<Libro> getMapeadorProducto();

	/**
	 * Sets the mapeador libro.
	 *
	 * @param mapeadorLibro
	 *            the new mapeador libro
	 */
//	public void setMapeadorLibro(RowMapper<Libro> mapeadorLibro);

	/**
	 * Gets the plantilla.
	 *
	 * @return the plantilla
	 */
//	public NamedParameterJdbcTemplate getPlantilla();

	/**
	 * Sets the plantilla.
	 *
	 * @param plantilla
	 *            the new plantilla
	 */
//	public void setPlantilla(NamedParameterJdbcTemplate plantilla);
}
