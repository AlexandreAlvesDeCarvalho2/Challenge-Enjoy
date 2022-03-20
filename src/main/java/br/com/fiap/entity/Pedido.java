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
	@Column(name="id_pedido")
	@SequenceGenerator(name="pedido",sequenceName="sq_t_pedido",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pedido")
	private int idPedido;
	
	@Column(name="hr_pedido", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar hrPedido;
	
	@Column(name="ds_produto",length = 25, nullable = false)
	private String dsProduto;
	
	@Column(name="ds_tipo_produto", length = 25, nullable = false)
	private String dsTipoProduto;
	
	@Column(name="vl_pedido", nullable = false)
	private double vlPedido;
	
	@Column(name= "qt_pedido", nullable = false)
	private double qtPedido;
	
	// --------------------- relações------------------------
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_visita")
	private Visita pedidos;
	
	
	
	// --------------------- Construtores------------------------
	public Pedido() {}



	public Pedido(int id_pedido, Calendar hr_pedido, String ds_produto, String ds_tipo_produto, double vl_pedido,
			double qt_pedido, Visita pedidos) {
		super();
		this.idPedido = id_pedido;
		this.hrPedido = hr_pedido;
		this.dsProduto = ds_produto;
		this.dsTipoProduto = ds_tipo_produto;
		this.vlPedido = vl_pedido;
		this.qtPedido = qt_pedido;
		this.pedidos = pedidos;
	}

	// ---------------------Getters and Setters------------------------

	public int getId_pedido() {
		return idPedido;
	}



	public void setId_pedido(int id_pedido) {
		this.idPedido = id_pedido;
	}



	public Calendar getHr_pedido() {
		return hrPedido;
	}



	public void setHr_pedido(Calendar hr_pedido) {
		this.hrPedido = hr_pedido;
	}



	public String getDs_produto() {
		return dsProduto;
	}



	public void setDs_produto(String ds_produto) {
		this.dsProduto = ds_produto;
	}



	public String getDs_tipo_produto() {
		return dsTipoProduto;
	}



	public void setDs_tipo_produto(String ds_tipo_produto) {
		this.dsTipoProduto = ds_tipo_produto;
	}



	public double getVl_pedido() {
		return vlPedido;
	}



	public void setVl_pedido(double vl_pedido) {
		this.vlPedido = vl_pedido;
	}



	public double getQt_pedido() {
		return qtPedido;
	}



	public void setQt_pedido(double qt_pedido) {
		this.qtPedido = qt_pedido;
	}



	public Visita getPedidos() {
		return pedidos;
	}



	public void setPedidos(Visita pedidos) {
		this.pedidos = pedidos;
	}
	
}
