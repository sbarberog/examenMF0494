package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Infractor;

public class InfractorDAO {

	private ConexionBD conex;
	
	public InfractorDAO() {
		this.conex = new ConexionBD();
	}
	
	public ArrayList<Infractor> obtenerInfractores() {
		
		Connection con = conex.getConexion();
		Statement consulta = null;
		ResultSet res = null;
		ArrayList<Infractor> lista = new ArrayList<Infractor>();
		
		try {
			consulta = con.createStatement();
			res = consulta.executeQuery("select * from infractores");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(res.next()) {
				String dni= res.getString("dni");
				String nombre=res.getString("nombre");
				String apellidos=res.getString("apellidos");
				int antiguedad = res.getInt("antiguedad");
				float sancion = res.getFloat("sancion");
				int puntos = res.getInt("puntos");
				
				Infractor i = new Infractor(dni,nombre,apellidos,antiguedad,sancion,puntos);
				lista.add(i);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre infractores: "
					+e.getMessage());
		} finally {
			try {
				res.close();
				consulta.close();
				conex.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lista;
		
	}
	
	public int insertarInfractor(Infractor i) {
    	
		Connection con = conex.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO infractores(dni,nombre,apellidos,"
					+ "antiguedad,sancion,puntos) \r\n"
					+ "VALUES\r\n"
					+ "(?,?,?,?,?,?)");
			
			consulta.setString(1, i.getDni());
			consulta.setString(2, i.getNombre());
			consulta.setString(3, i.getApellidos());
			consulta.setInt(4, i.getAntiguedad());
			consulta.setFloat(5, i.getSancion());
			consulta.setInt(6, i.getPuntos());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción de un infractor: "
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conex.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }
	
}
