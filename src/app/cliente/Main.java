/*	PRACTICA 1 MASTER AVANZADO JEE
 * 	Jorge Aguado
 */
package app.cliente;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String args[]) {
		// Obtengo el contenedor de Beans
		ApplicationContext contenedor = new ClassPathXmlApplicationContext("spring.xml");
		ItfzGestionLibreria beanNegocio = (ItfzGestionLibreria) contenedor
				.getBean("negocio");

		menuPrincipal(beanNegocio);
		((AbstractApplicationContext) contenedor).close();
	}

	/**
	 * Menu get string.
	 *
	 * @param message
	 *            , mensaje que se pide por pantalla al usuario
	 * @param in
	 *            the in
	 * @return string, información obtenida del usuario por consola
	 */
	public static String menuGetString(String message, Scanner in) {
		System.out.println(message);
		String mensaje = in.nextLine();
		return mensaje;
	}

	/**
	 * Menu precio.
	 *
	 * @param in
	 *            the in
	 * @return precio obtenido del usuario por consola
	 */
	
	public static double menuPrecio(Scanner in) {
		double precio = 0.0;
		boolean decimal = true;
		do {
			System.out.println("Introduce el precio: ");
			String input = in.nextLine();
			decimal = true;
			try {
				precio = Double.parseDouble(input);
			} catch (NumberFormatException e) {// Si no es un numero compatible
												// con decimales
				System.out
						.println("-- El precio debe ser un numero decimal --");
				decimal = false;
			}
		} while (decimal != true);// Haz mientras no sea decimal
		return precio;
	}

	/**
	 * Menu publicacion.
	 *
	 * @param message the message
	 * @param in            the in
	 * @return publicacion obtenida del usuario por consola
	 */
	
	
	public static int menuGetEntero(String message, Scanner in) {
		int valor = 0;
		boolean entero = true;
		do {
			System.out.println(message);
			String input = in.nextLine();
			entero = true;
			try {
				valor = Integer.parseInt(input);
			} catch (NumberFormatException e) {// Si no es un numero entero
				System.out.println("-- El valor introducido debe ser un entero --");
				entero = false;
			}
		} while (entero != true);// Haz mientras no es entero
		return valor;
	}

	
	/**
	 * Menu autor.
	 *
	 * @param in the in
	 * @return the list
	 */
	public static List<Autor> menuAutor(Scanner in) {

		List<Autor> autores = new ArrayList<Autor>();
		int opAutor = 0;

		do{
			
			String nombre, nacionalidad, comentarios;
			nombre = menuGetString("**Autor** Introduce el nombre del Autor", in);
			nacionalidad = menuGetString("**Autor** Introduce la nacionalidad del Autor", in);
			comentarios = menuGetString("**Autor** Introduce comentarios del Autor", in);
			Autor autor =  new Autor(new AutorPK(nombre, nacionalidad), comentarios);
			autores.add(autor);
			opAutor = menuGetEntero("[1] Introducir un nuevo Autor \n[Cualquier otro numero] No más autores", in);// Recogo la opción por pantalla

		}while(opAutor == 1);
		
		return autores;
	}
	
	
	/**
	 * Menu editorial.
	 *
	 * @param in the in
	 * @return the editorial
	 */
	public static Editorial menuEditorial(Scanner in) {

			Direccion direccion = new Direccion();
			String nombre, nacionalidad,nif , comentarios;
			nombre = menuGetString("**Editorial** Introduce el nombre de la editorial", in);
			direccion.setCalle(menuGetString("**Editorial** Introduce la calle de la editorial", in));
			direccion.setNumero(menuGetEntero("**Editorial** Introduce el numero de la calle", in));
			direccion.setCp(menuGetEntero("**Editorial** Introduce el codigo postal", in));
			direccion.setPoblacion(menuGetString("**Editorial** Introduce la Poblacion de la calle", in));
			direccion.setProvincia(menuGetString("**Editorial** Introduce la provincia", in));
			nif = menuGetString("**Editorial** Introduce el nif de la editorial", in);
			Editorial editorial = new Editorial(new EditorialPK(nif), nombre, direccion);
		
		return editorial;
	}
	

	/**
	 * Menu principal.
	 *
	 * @param beanNegocio
	 *            the bean negocio
	 */
	
	public static void menuPrincipal(ItfzGestionLibreria beanNegocio) {
		List<Autor> autores = null;
		Editorial editorial = null;
		Scanner inOption = new Scanner(System.in);
		Scanner in = new Scanner(System.in);

		String isbn, titulo, descripcion;
		int publicacion, op = 0, opAutor = 0;
		double precio;

		do {// Estas son las opciones que tiene el usuario
			System.out.println("*****************************");
			System.out.println("[1] Alta libro");
			System.out.println("[2] Eliminar libro");
			System.out.println("[3] Consultar todos");
			System.out.println("[4] Consultar libro por ISBN");
			System.out.println("[5] Consultar libro por titulo");
			System.out.println("[6] Modificar precio de libro");

			System.out.println("[0] SALIRn");
			System.out.println("Ingresa una opcion:");
			op = inOption.nextInt();// Recogo la opción por pantalla
			switch (op) {
			case 1:
				isbn = menuGetString("Introduce el Isbn", in);
				titulo = menuGetString("Introduce el titulo", in);
				
				publicacion = menuGetEntero("Introduce la publicacion",in);
				precio = menuPrecio(in);
				descripcion = menuGetString("Introduce la descripcion", in);

				autores = menuAutor(in);
				editorial = menuEditorial(in);
				
				Libro libro = new Libro(titulo, isbn,
						publicacion, precio, descripcion);
				for(Autor a:autores)
					libro.addAutor(a);
				
				libro.addEditorial(editorial);
				
				beanNegocio.altaLibro(libro);

				break;
			case 2:
				isbn = menuGetString("Introduce el isbn", in);
				beanNegocio.eliminarLibro(isbn);
				break;
			case 3:
				beanNegocio.consultarTodos();
				break;
			case 4:
				isbn = menuGetString("Introduce el isbn", in);
				beanNegocio.consultarISBN(isbn);
				break;
			case 5:
				titulo = menuGetString("Introduce el titulo", in);
				beanNegocio.consultarTitulo(titulo);
				break;
			case 6:
				isbn = menuGetString("Introduce el isbn", in);
				precio = menuPrecio(in);
				beanNegocio.modificarPrecio(isbn, precio);
				break;
			}
		} while (op != 0);
		in.close();
		inOption.close();
	}

}
