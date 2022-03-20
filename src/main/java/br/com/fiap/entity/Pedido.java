package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_pedido")
public class Pedido {
	
	@Id
    @SequenceGenerator(name="pedido",sequenceName="sq_t_pedido",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pedido")
	private int id_pedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar hr_pedido;
	
	@Column(length = 25, nullable = false)
	private String ds_produto;
	
	@Column(length = 25, nullable = false)
	private String ds_tipo_produto;
	
	@Column(nullable = false)
	private double vl_pedido;
	
	@Column(nullable = false)
	private double qt_pedido;
	
	// --------------------- relações------------------------
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_visita")
	private Visita pedidos;
	
	
	
	// --------------------- Construtores------------------------
	public Pedido() {}



	public Pedido(int id_pedido, Calendar hr_pedido, String ds_produto, String ds_tipo_produto, double vl_pedido,
			double qt_pedido, Visita pedidos) {
		super();
		this.id_pedido = id_pedido;
		this.hr_pedido = hr_pedido;
		this.ds_produto = ds_produto;
		this.ds_tipo_produto = ds_tipo_produto;
		this.vl_pedido = vl_pedido;
		this.qt_pedido = qt_pedido;
		this.pedidos = pedidos;
	}

	// ---------------------Getters and Setters------------------------

	public int getId_pedido() {
		return id_pedido;
	}



	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}



	public Calendar getHr_pedido() {
		return hr_pedido;
	}



	public void setHr_pedido(Calendar hr_pedido) {
		this.hr_pedido = hr_pedido;
	}



	public String getDs_produto() {
		return ds_produto;
	}



	public void setDs_produto(String ds_produto) {
		this.ds_produto = ds_produto;
	}



	public String getDs_tipo_produto() {
		return ds_tipo_produto;
	}



	public void setDs_tipo_produto(String ds_tipo_produto) {
		this.ds_tipo_produto = ds_tipo_produto;
	}



	public double getVl_pedido() {
		return vl_pedido;
	}



	public void setVl_pedido(double vl_pedido) {
		this.vl_pedido = vl_pedido;
	}



	public double getQt_pedido() {
		return qt_pedido;
	}



	public void setQt_pedido(double qt_pedido) {
		this.qt_pedido = qt_pedido;
	}



	public Visita getPedidos() {
		return pedidos;
	}



	public void setPedidos(Visita pedidos) {
		this.pedidos = pedidos;
	}
	// ---------------------ToString------------------------

	@Override
	public String toString() {
		return "Pedido ["
				+ "id_pedido=" + id_pedido
				+ ", hr_pedido=" + hr_pedido
				+ ", ds_produto=" + ds_produto
				+ ", ds_tipo_produto=" + ds_tipo_produto
				+ ", vl_pedido=" + vl_pedido
				+ ", qt_pedido=" + qt_pedido
				+ "]";
	}
	
	
	
	
	
}
