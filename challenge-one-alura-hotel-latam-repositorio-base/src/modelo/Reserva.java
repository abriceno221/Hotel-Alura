package modelo;

import java.math.BigDecimal;

import java.sql.Date;


public class Reserva {

	private Integer id;
	private Date fechaEntradaDate;
	private Date fechaSalida;
	private BigDecimal valor;
	private String formaDePago;
	
	public Reserva(Date fechaEntradaDate, Date fechaSalida, BigDecimal valor,
			String formaDePago) {
		this.fechaEntradaDate = fechaEntradaDate;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}
	
	public Reserva(Integer id, Date fechaEntradaDate, Date fechaSalida, BigDecimal valor,
			String formaDePago) {
		this.id = id;
		this.fechaEntradaDate = fechaEntradaDate;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}
	
	public Reserva(int idReserva) {
		this.id = idReserva;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFechaEntradaDate() {
		return fechaEntradaDate;
	}
	public void setFechaEntradaDate(Date fechaEntradaDate) {
		this.fechaEntradaDate = fechaEntradaDate;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalda) {
		this.fechaSalida = fechaSalda;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	@Override
	public String toString() {
		return ("Fecha de entrada: " + this.fechaEntradaDate + " Fecha salida: "
				+ this.fechaSalida + " Valor a pagar: " + this.valor + " Forma de pago: "
				+this.formaDePago);
	}
	
}
