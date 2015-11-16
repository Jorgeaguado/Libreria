/**
 * 
 */
package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Autor.
 *
 * @author Jorgeag
 */
public class Autor implements Serializable {
	
	/**
	 * Instantiates a new autor.
	 */
	public Autor() {
		super();
	}


	/**
	 * Instantiates a new autor.
	 *
	 * @param pk the pk
	 * @param comentarios the comentarios
	 */
	public Autor(AutorPK pk, String comentarios) {
		super();
		this.pk = pk;
		this.comentarios = comentarios;
	}

	/** The pk. */
	private AutorPK pk;

	/** The comentarios. */
	private String comentarios;

	/** The libros. */
	private Set<Libro> libros = new HashSet<Libro>();



	
    /**
     * Adds the libro.
     *
     * @param libro the libro
     */
    public void addLibro(Libro libro){
        libros.add(libro);
    }
    



	/**
	 * Gets the comentarios.
	 *
	 * @return the comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * Sets the comentarios.
	 *
	 * @param comentarios            the comentarios to set
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	/**
	 * Gets the libros.
	 *
	 * @return the libros
	 */
	public Set<Libro> getLibros() {
		return libros;
	}

	/**
	 * Sets the libros.
	 *
	 * @param libros the libros to set
	 */
	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}


	/**
	 * Gets the pk.
	 *
	 * @return the pk
	 */
	public AutorPK getPk() {
		return pk;
	}


	/**
	 * Sets the pk.
	 *
	 * @param pk the pk to set
	 */
	public void setPk(AutorPK pk) {
		this.pk = pk;
	}


}
