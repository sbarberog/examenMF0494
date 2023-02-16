/**
 * 
 */
package controlador;

import java.util.ArrayList;

import dao.InfractorDAO;
import dao.SancionDAO;
import modelo.Infractor;
import modelo.Sancion;
import uf2179.VentanaMultas;
import vista.DialogoInsertarInfractor;
import vista.VentanaMostrarInfractores;
import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	// VEntanas del sistema
	private VentanaPpal ventanaPpal;
	private DialogoInsertarInfractor dialogoInsertarInfractor;
	private VentanaMostrarInfractores ventanaMostrarInfractores;
	private VentanaMultas ventanaMultas;

	
	// Objetos DAO o CRUD de la base de datos
	private SancionDAO sancionDAO;
	private InfractorDAO infractorDAO;

	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		dialogoInsertarInfractor = new DialogoInsertarInfractor();
		ventanaMostrarInfractores= new VentanaMostrarInfractores();
		ventanaMultas= new VentanaMultas();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoInsertarInfractor.setControlador(this);
		ventanaMostrarInfractores.setControlador(this);
		ventanaMultas.setControlador(this);
		
		// Creamos los objetos DAO
		sancionDAO = new SancionDAO();
		infractorDAO= new InfractorDAO();
	}
	
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}

	public void mostrarInsertarInfractores () {
		ArrayList<Sancion> listaSanciones = new ArrayList<Sancion>();
		listaSanciones = sancionDAO.obtenerSanciones();
		dialogoInsertarInfractor.setListaSanciones(listaSanciones);
		dialogoInsertarInfractor.setVisible(true);
	}
	
	public void mostrarInfractores() {
		ArrayList<Infractor> listaInfractores = new ArrayList<Infractor>();
		listaInfractores= infractorDAO.obtenerInfractores();
		ventanaMostrarInfractores.setListaInfractores(listaInfractores);
		ventanaMostrarInfractores.setVisible(true);
	}
	
}
