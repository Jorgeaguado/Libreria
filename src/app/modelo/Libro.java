/*	PRACTICA 3 MASTER AVANZADO JEE
 * 	Jorge Aguado
 */
package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Libro.
 */
public class Libro implements Serializable{
	
	/** The id. */
	private Long id;

	/** The titulo. */
	private String titulo;

	/** The isbn. */
	private String isbn;

	/** The publicacion. */
	private int publicacion;

	/** The precio. */
	private double precio;

	/** The descripcion. */
	private String descripcion;
	
	/** The autores. */
	private Set<Autor> autores = new HashSet<Autor>();
	
	/** The editorial1. */
	private Editorial editorial1;


	/**
	 * Instantiates a new libro.
	 */
	public Libro() {
	}

	/**
	 * Instantiates a new libro.
	 *
	 * @param t            , titulo
	 * @param i            , isbn
	 * @param pu            , publicacion
	 * @param pre            , precio
	 * @param d            , descripcion
	 */
	public Libro(String t,  String i, int pu, double pre,
			String d) {
		this.titulo = t;
		this.isbn = i;
		this.publicacion = pu;
		this.precio = pre;
		this.descripcion = d;
	}
	
	/**
	 * Adds the autor.
	 *
	 * @param autor the autor
	 */
	public void addAutor(Autor autor){
        autores.add(autor);
        autor.getLibros().add(this);
    }

	/**
	 * Adds the editorial.
	 *
	 * @param editorial the editorial
	 */
	public void addEditorial(Editorial editorial){
		this.editorial1 = editorial;
		editorial.addLibro(this);
	}
	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the titulo.
	 *
	 * @param titulo
	 *            the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	/**
	 * Gets the isbn.
	 *
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Sets the isbn.
	 *
	 * @param isbn
	 *            the new isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the publicacion.
	 *
	 * @return the publicacion
	 */
	public int getPublicacion() {
		return publicacion;
	}

	/**
	 * Sets the publicacion.
	 *
	 * @param publicacion
	 *            the new publicacion
	 */
	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}

	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Sets the precio.
	 *
	 * @param precio
	 *            the new precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion
	 *            the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the autores.
	 *
	 * @return the autores
	 */
	public Set<Autor> getAutores() {
		return autores;
	}

	/**
	 * Sets the autores.
	 *
	 * @param autores the autores to set
	 */
	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	/**
	 * Gets the editorial1.
	 *
	 * @return the editorial1
	 */
	public Editorial getEditorial1() {
		return editorial1;
	}

	/**
	 * Sets the editorial1.
	 *
	 * @param editorial1 the editorial1 to set
	 */
	public void setEditorial1(Editorial editorial1) {
		this.editorial1 = editorial1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", isbn=" + isbn + ", publicacion="
				+ publicacion + ", precio=" + precio + ", descripcion="
				+ descripcion + ", autores=" + autores + ", editorial1="
				+ editorial1 + "]";
	}
}
