/**
 * 
 */
package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class Editorial.
 *
 * @author Jorgeag
 */
public class Editorial implements Serializable{
	
	/**
	 * Instantiates a new editorial.
	 */
	public Editorial() {
		super();
	}





	/**
	 * Instantiates a new editorial.
	 *
	 * @param pk the pk
	 * @param nombre the nombre
	 * @param direccion the direccion
	 */
	public Editorial(EditorialPK pk, String nombre, Direccion direccion) {
		super();
		this.pk = pk;
		this.nombre = nombre;
		this.direccion = direccion;
	}





	/** The pk. */
	private EditorialPK pk;
	
	/** The nombre. */
	private String nombre;
	
	/** The direccion. */
	private Direccion direccion;
	
 
	/** The libros. */
	private Set<Libro> libros = new HashSet<Libro>();





    /**
     * Adds the libro.
     *
     * @param libro the libro
     */
    public void addLibro(Libro libro){
        libros.add(libro);
        //libro.setEditorial1(this);
    }





	/**
	 * Gets the pk.
	 *
	 * @return the pk
	 */
	public EditorialPK getPk() {
		return pk;
	}





	/**
	 * Sets the pk.
	 *
	 * @param pk the pk to set
	 */
	public void setPk(EditorialPK pk) {
		this.pk = pk;
	}





	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}





	/**
	 * Sets the nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public Direccion getDireccion() {
		return direccion;
	}





	/**
	 * Sets the direccion.
	 *
	 * @param direccion the direccion to set
	 */
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((libros == null) ? 0 : libros.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		return result;
	}





	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editorial other = (Editorial) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (libros == null) {
			if (other.libros != null)
				return false;
		} else if (!libros.equals(other.libros))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
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

}
