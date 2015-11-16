/**
 * 
 */
package app.modelo;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class EditorialPK.
 *
 * @author Jorgeag
 */
public class EditorialPK implements Serializable{
	
	/**
	 * Instantiates a new editorial pk.
	 */
	public EditorialPK() {
		super();
	}

	/**
	 * Instantiates a new editorial pk.
	 *
	 * @param nif the nif
	 */
	public EditorialPK(String nif) {
		super();
		this.nif = nif;
	}

	/** The nif. */
	private String nif;

	/**
	 * Gets the nif.
	 *
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * Sets the nif.
	 *
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
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
		EditorialPK other = (EditorialPK) obj;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}
	
	

}
