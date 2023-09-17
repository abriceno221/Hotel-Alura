package controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import dao.ReservaDao;
import factory.ConnectionFactory;
import modelo.Reserva;

public class ReservaController {
	
	ReservaDao reservaDao;
	
	public ReservaController() {
		this.reservaDao = new ReservaDao(new ConnectionFactory().recuperConexion());
	}
	
	public int guardarReserva(Reserva reserva) {
		return reservaDao.guardarReserva(reserva);
	}
	
	public List<Reserva> listarReservas(){
		return reservaDao.listarReservas();
	}

	public int eliminar(Integer id) {
		return reservaDao.eliminarReserva(id);
	}

	public int modificar(Integer id, Date fechaEntrada, Date fechaSalida, BigDecimal valor, String formaDePago) {
		return reservaDao.modificarReserva(id, fechaEntrada, fechaSalida, valor, formaDePago);
	}
	
}
