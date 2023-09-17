package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Huesped;


public class HuespedDao {
	final private Connection con;
	
	public HuespedDao(Connection con) {
		this.con = con;
	}
	//Falta terminar la query cuando sepa donde se encuentra password y usuario
	public Map<String, String> listarUsuarioClave() {
		Map<String, String> datosBasicos = new HashMap<>();
		try(con){
			final PreparedStatement statement = con.prepareStatement("la query para usuario contrasha");
			try(statement){
				statement.execute();
				final ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while(resultSet.next()) {
						datosBasicos.put(resultSet.getString("USUARIO"), resultSet.getString("PASSWORD"));
					}
				}
			}
			
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return datosBasicos;
	}
	
	public int guardarHuesped(Huesped huesped) {
		ResultSet resultSet;
		try(con){
			final PreparedStatement statement = con.prepareStatement("INSERT INTO HUESPEDES (nombre, apellido, "
					+ "fechaDeNacimiento, nacionalidad, telefono, idReserva) VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
				try(statement) {
					statement.setString(1, huesped.getNombre());
					statement.setString(2, huesped.getApellido());		
					statement.setDate(3, huesped.getFechaNacimiento());
					statement.setString(4, huesped.getNacionalidad());
					statement.setString(5, huesped.getTelefono());
					statement.setInt(6, huesped.getReserva().getId());
					statement.execute();	
					resultSet = statement.getGeneratedKeys();
					try(resultSet){
						if(resultSet.next()) {
							return resultSet.getInt(1);
						}else {
							return 0;
						}
					}
				}
				
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huesped> listarHuespedes(){
		List<Huesped> huespedes = new ArrayList<>();
		
		try(con){
			final PreparedStatement statement = con.prepareStatement("SELECT id, nombre, apellido, fechaDeNacimiento, nacionalidad, telefono,"
					+ " idReserva FROM huespedes");
			try(statement){
				statement.execute();
				
				final ResultSet resultSet = statement.getResultSet();
				
				try(resultSet){
					while(resultSet.next()){
						Huesped huesped = new Huesped(resultSet.getInt("id"),
								resultSet.getString("nombre"),
								resultSet.getString("apellido"),
								resultSet.getDate("fechaDeNacimiento"),
								resultSet.getString("nacionalidad"),
								resultSet.getString("telefono"),
								resultSet.getInt("idReserva"));
						
						huespedes.add(huesped);
					}
				}
			}
			return huespedes;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int eliminarHuesped(int id) {
		try(con){
			final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE id = ?");
			try(statement){
				statement.setInt(1, id);
				statement.execute();
				
				return statement.getUpdateCount();
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int modificarHuesped(Integer id, String nombre, String apellido, Date nacimiento, String nacionalidad,
			String telefono) {
		try(con){
			final PreparedStatement statement = con.prepareStatement("UPDATE huespedes SET nombre = ?, apellido = ?"
					+ ", fechaDeNacimiento = ?, nacionalidad = ?, telefono = ? WHERE ID = ?");
			try(statement){
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setDate(3, nacimiento);
				statement.setString(4, nacionalidad);
				statement.setString(5, telefono);
				statement.setInt(6, id);
				statement.execute();
				
				return statement.getUpdateCount();
				
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
