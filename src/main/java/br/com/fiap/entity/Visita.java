package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="t_visita")
public class Visita {
	
	@Id
	@Column(name="id_visita", nullable = false)
    @SequenceGenerator(name="visita",sequenceName="sq_t_visita",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="visita")
	private int idVisita;
	
	@Column(name="dt_visita", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dtVisita;
	
	@Column(name="vlr_total", nullable = false)
	private double vlr_total;
	
		
	// --------------------- relações------------------------

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "nr_telefone")
	private Consumidor visitas;
	
	@OneToMany(mappedBy = "pedidos")
	private List<Pedido> pedido;

	@OneToOne
	@JoinColumn(name = "nr_cnpj")
	private Estabelecimento estabelecimentos;
	
	
	// --------------------- Construtores------------------------
	
	public Visita() {}
	
	public Visita(int id_visita, Calendar dt_visita, double vlr_total, Estabelecimento estabelecimento,
			Consumidor visitas, List<Pedido> pedido) {
		super();
		this.idVisita = id_visita;
		this.dtVisita = dt_visita;
		this.vlr_total = vlr_total;
		this.visitas = visitas;
		this.pedido = pedido;
	}
	
	
	
	// ---------------------Getters And Setters------------------------
	
	public int getId_visita() {
		return idVisita;
	}

	public void setId_visita(int id_visita) {
		this.idVisita = id_visita;
	}

	public Calendar getDt_visita() {
		return dtVisita;
	}

	public void setDt_visita(Calendar dt_visita) {
		this.dtVisita = dt_visita;
	}

	public double getVlr_total() {
		return vlr_total;
	}

	public void setVlr_total(double vlr_total) {
		this.vlr_total = vlr_total;
	}

	public Consumidor getVisitas() {
		return visitas;
	}

	public void setVisitas(Consumidor visitas) {
		this.visitas = visitas;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

}
