/**
 * 
 */
package app.cliente;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.modelo.Autor;
import app.modelo.AutorPK;
import app.modelo.Direccion;
import app.modelo.Editorial;
import app.modelo.EditorialPK;
import app.modelo.Libro;
import app.negocio.*;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


// TODO: Auto-generated Javadoc
/**
 * The Class MainCrear.
 *
 * @author Jorgeag
 */
public class MainCrear {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		ApplicationContext contenedor = new ClassPathXmlApplicationContext("spring.xml");
        SessionFactory sf = (SessionFactory) contenedor.getBean("sessionFactory");
        
		ItfzGestionLibreria beanNegocio = (ItfzGestionLibreria) contenedor
				.getBean("negocio");
		
		
        Session session = sf.openSession();	
        Transaction tx = session.getTransaction();
        
        Libro libro1 = new Libro(" El umbral de la eternidad",  "23334534", 12, 18.0,"Después de La caída de los gigantes y El invierno del mundo llega el final de la gran historia de las cinco familias cuyas vidas se han entrelazado a través del siglo XX ...");
        Libro libro2 = new Libro("El almirante flotante", "2344442", 9,34.21, "Catorce miembros del prestigioso The Detection Club, entre ellos autores de la talla de A. Christie, D. L. Sayers, G. K. Chesterton o R. Knox, recibieron la propuesta  ..." );

        
        Autor autor1 = new Autor(new AutorPK("Ken Follett", "Inglaterra"), " No comentarios");
        Autor autor2 = new Autor(new AutorPK("G. Chesterton", "Inglaterra"), "No comentarios");
        Autor autor3 = new Autor(new AutorPK("Agatha Christie", "Inglaterra"), "No comentarios");
        
        Direccion direccion1 = new Direccion("Calle Rafael Alberti", 1,"Granada",18221,"Granada");
        Direccion direccion2 = new Direccion("Calle Antonio Pelaez", 4,"Granada",1844221,"Jaen");

        
        Editorial editorial1 = new Editorial(new EditorialPK("15575178-C"),"Nativola", direccion1);
        Editorial editorial2 = new Editorial(new EditorialPK("12345178-C"),"something", direccion2);

        
        libro1.addAutor(autor1);
        libro1.addAutor(autor2);

        libro1.addEditorial(editorial2);
        beanNegocio.altaLibro(libro1);

        
        libro2.addAutor(autor2);
        libro2.addAutor(autor3);
        libro2.addEditorial(editorial1);
        beanNegocio.altaLibro(libro2);
        
	}

}
