/**
 * 
 */
package app.modelo;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Direccion.
 *
 * @author Jorgeag
 */
public class Direccion implements Serializable{
	
	/** The id. */
	private Long id;
	
	/** The calle. */
	private String calle;
	
	/** The numero. */
	private int numero;
	
	/** The poblacion. */
	private String poblacion;
	
	/** The cp. */
	private int cp;
	
	/** The provincia. */
	private String provincia;
	
	
	/**
	 * Instantiates a new direccion.
	 */
	public Direccion() {
		super();
	}

	/**
	 * Instantiates a new direccion.
	 *
	 * @param calle the calle
	 * @param numero the numero
	 * @param poblacion the poblacion
	 * @param cp the cp
	 * @param provincia the provincia
	 */
	public Direccion(String calle, int numero, String poblacion, int cp,
			String provincia) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.cp = cp;
		this.provincia = provincia;
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
	 * Gets the calle.
	 *
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * Sets the calle.
	 *
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Gets the poblacion.
	 *
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * Sets the poblacion.
	 *
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * Gets the cp.
	 *
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * Sets the cp.
	 *
	 * @param cp the cp to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}

	/**
	 * Gets the provincia.
	 *
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * Sets the provincia.
	 *
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + cp;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numero;
		result = prime * result
				+ ((poblacion == null) ? 0 : poblacion.hashCode());
		result = prime * result
				+ ((provincia == null) ? 0 : provincia.hashCode());
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
		Direccion other = (Direccion) obj;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (cp != other.cp)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero != other.numero)
			return false;
		if (poblacion == null) {
			if (other.poblacion != null)
				return false;
		} else if (!poblacion.equals(other.poblacion))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", numero=" + numero
				+ ", poblacion=" + poblacion + ", cp=" + cp + ", provincia="
				+ provincia + "]";
	}
	
	

}
