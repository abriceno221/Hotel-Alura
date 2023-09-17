package controller;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import dao.HuespedDao;
import factory.ConnectionFactory;
import modelo.Huesped;

public class HuespedController {
	
	private HuespedDao huespedDao;
	
	public HuespedController() {
		this.huespedDao = new HuespedDao(new ConnectionFactory().recuperConexion());
	}
	
	public Map<String, String> listarUsuarioClave(){
		return huespedDao.listarUsuarioClave();
	}
	
	public int guardarHuesped(Huesped huesped) {
		return huespedDao.guardarHuesped(huesped);
	}
	
	public List<Huesped> listarHuespedes(){
		return huespedDao.listarHuespedes();
	}

	public int eliminar(Integer id) {
		return huespedDao.eliminarHuesped(id);
	}

	public int modificar(Integer id, String nombre, String apellido, Date nacimiento, String nacionalidad,
			String telefono) {
		return huespedDao.modificarHuesped(id, nombre, apellido, nacimiento, nacionalidad, telefono);
	}

}
