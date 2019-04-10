package Reto4Grupo1BBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModificarBBDD {

	/**
	* Metodo para consultar en la base de datos
	 * @param con Conexion a la base de datos
	 * @param query Consulta a realizar de tipo SELECT
	 * @return ResultSet con los resultados de la consulta realizada
	 */
	public ResultSet hacerConsultaBD (Connection con, String query) {
		ResultSet rs = null;
		
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			//Implementar logger?
			System.out.println(e.getMessage());
		}
	
		return rs;
	}
	
	/**
	 * Metodo para insertar valores en una tabla de la base de datos
	 * @param con Conexion a la base de datos
	 * @param query Consulta a realizar de tipo INSERT
	 * @return boolean true si se ha realizado la insercion con exito, false si no
	 */
	public int insertarDatosBD(Connection con, String query) {
		Statement st;
		int codReserva;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			//Implementar logger?
			e1.printStackTrace();
			return -1;
		}
		
		try {
			st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet  result = st.getGeneratedKeys();
			result.next();
		    codReserva = result.getInt(1);
		} catch (Exception e){
			//Implementar logger?
			System.out.println(e.getMessage());
			return -1;
		}

		return codReserva;
	}
}
