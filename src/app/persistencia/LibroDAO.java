/*	PRACTICA 3 MASTER AVANZADO JEE
 * 	Jorge Aguado
 */
package app.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.modelo.Libro;

// TODO: Auto-generated Javadoc
/**
 * LibroNoEncontradoException Extiende la clase Exception, se le pasa como
 * argumento el mensaje
 */
class LibroNoEncontradoException extends Exception {
	public LibroNoEncontradoException(String msg) {
		super(msg);
	}
}

/**
 * The Class LibroDAO.
 */
public class LibroDAO implements ItfzLibrosDao {
	
	/**
	 * Instantiates a new libro dao.
	 */
	public LibroDAO() {
		super();
	}

	/** The session factory. */
	private SessionFactory sessionFactory;

	/** The session. */
	private Session session = null;

	/**
	 * Gets the current session.
	 *
	 * @return the current session
	 */
	public Session getCurrentSession() {

		if (session == null) {
			try {
				session = sessionFactory.openSession();
			} catch (HibernateException he) {
				he.printStackTrace();
			}
		}

		if (sessionFactory.isClosed()) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	/* (non-Javadoc)
	 * @see app.persistencia.ItfzLibrosDao#altaLibro(app.modelo.Libro)
	 */
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean altaLibro(Libro libro) {
		boolean alta = true;
		try {
			Session session1 = sessionFactory.getCurrentSession();
			if (!encuentraLibro(libro.getIsbn()))
				session1.save(libro);
			else
				alta = false;
		} catch (Exception e) {
			alta = false;
			e.printStackTrace();
		}
		return alta;
	}

	/* (non-Javadoc)
	 * @see app.persistencia.ItfzLibrosDao#eliminarLibro(java.lang.String)
	 */
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean eliminarLibro(String ISBN) {

		boolean eliminado = true;
		boolean encontrado = true;

		try {
			encuentraLibroIsbn(ISBN);
			String hql = "delete from Libro where isbn= :isbn";
			getCurrentSession().createQuery(hql).setString("isbn", ISBN)
					.executeUpdate();

		} catch (LibroNoEncontradoException lnee) {
			eliminado = false;
			System.err.println(lnee.getMessage());
		} catch (Exception e) {
			eliminado = false;
			e.printStackTrace();
		}

		return eliminado;
	}

	/**
	 * Gets the session factory.
	 *
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see app.persistencia.ItfzLibrosDao#consultarTodos()
	 */
	public List<Libro> consultarTodos() {
		List<Libro> libros = new ArrayList<Libro>();
		List results = new ArrayList();

		try {
			String hql = "FROM Libro";
			getCurrentSession().clear();
			Query query = getCurrentSession().createQuery(hql);
			results = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Object obj : results) {
			libros.add((Libro) obj);
		}

		return libros;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see app.persistencia.ItfzLibrosDao#consultarISBN(java.lang.String)
	 */
	public Libro consultarISBN(String isbn) {
		Libro libro = null;
		List<Libro> libros = null;
		try {
			encuentraLibroIsbn(isbn);
			libros = getCurrentSession().createCriteria(Libro.class)
					.add(Restrictions.eq("isbn", isbn)).list();
			libro = libros.get(0);
		} catch (LibroNoEncontradoException lnee) {
			System.err.println(lnee.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return libro;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see app.persistencia.ItfzLibrosDao#consultarTitulo(java.lang.String)
	 */
	public List<Libro> consultarTitulo(String titulo) {
		List<Libro> libros = null;
		try {
			encuentraLibroTitulo(titulo);
			libros = getCurrentSession().createCriteria(Libro.class)
					.add(Restrictions.eq("titulo", titulo)).list();

		} catch (LibroNoEncontradoException lnee) {
			System.err.println(lnee.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libros;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see app.persistencia.ItfzLibrosDao#modificarPrecio(java.lang.String,
	 * double)
	 */
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public boolean modificarPrecio(String isbn, double precio) {
		boolean modified = true;
		Libro libro = null;

		try {
			encuentraLibroIsbn(isbn);
			String hql = "update Libro l set l.precio = :nuevoPrecio where l.isbn = :isbn";
			getCurrentSession().createQuery(hql).setString("isbn", isbn)
					.setDouble("nuevoPrecio", precio).executeUpdate();
		} catch (LibroNoEncontradoException lnee) {
			modified = false;
			System.err.println(lnee.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			modified = false;
		}
		return modified;

	}

	/**
	 * Encuentra libro isbn.
	 *
	 * @param isbn
	 *            the isbn
	 * @throws LibroNoEncontradoException
	 *             the libro no encontrado exception
	 */

	public void encuentraLibroIsbn(String isbn)
			throws LibroNoEncontradoException {
		List<Libro> libros = getCurrentSession().createCriteria(Libro.class)
				.add(Restrictions.eq("isbn", isbn)).list();
		if (libros.isEmpty())// La consulta de la BBDD no ha devuelto alguna
			// entrada
			throw new LibroNoEncontradoException(
					"[LibroNoEncontradoException] El libro no ha sido encontrado en la BBDD");
	}

	/**
	 * Encuentra libro titulo.
	 * 
	 * @param titulo
	 *            the titulo
	 * 
	 * @throws LibroNoEncontradoException
	 *             the libro no encontrado exception
	 */

	public void encuentraLibroTitulo(String titulo)
			throws LibroNoEncontradoException {

		List<Libro> libros = getCurrentSession().createCriteria(Libro.class)
				.add(Restrictions.eq("titulo", titulo)).list();
		if (libros.isEmpty())// La consulta de la BBDD no ha devuelto alguna entrada
			throw new LibroNoEncontradoException(
					"[LibroNoEncontradoException] El libro no ha sido encontrado en la BBDD");

	}

	/**
	 * Encuentra libro.
	 *
	 * @param isbn the isbn
	 * @return true, if successful
	 */
	public boolean encuentraLibro(String isbn) {

		List<Libro> libros = getCurrentSession().createCriteria(Libro.class)
				.add(Restrictions.eq("isbn", isbn)).list();
		if (libros.isEmpty())
			return false;
		return true;
	}


}
