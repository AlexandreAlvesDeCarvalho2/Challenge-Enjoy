package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_consumidor")
public class Consumidor {
	
	@SequenceGenerator(name = "consumidor", sequenceName = "sq_t_consumidor", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumidor")
	private int id_consumidor;
	
	@Id
	@Column(length = 12, nullable = false)
	private Long nr_telefone;

	@Column(nullable = false, length = 100)
	private String nm_consumidor;

	@Column(nullable = false, length = 40)
	private String email_consumidor;

	private String ds_genreo;

	@Temporal(TemporalType.DATE)
	private Calendar dt_nascimento;

	
	
	// --------------------- relações------------------------
	@OneToMany(mappedBy = "visitas")
	private List<Visita> visita;
	
	

	// --------------------- Construtores------------------------
	public Consumidor() {}

	public Consumidor(int id_consumidor, Long nr_telefone, String nm_consumidor, String email_consumidor,
			String ds_genreo, Calendar dt_nascimento, List<Visita> visita) {
		super();
		this.id_consumidor = id_consumidor;
		this.nr_telefone = nr_telefone;
		this.nm_consumidor = nm_consumidor;
		this.email_consumidor = email_consumidor;
		this.ds_genreo = ds_genreo;
		this.dt_nascimento = dt_nascimento;
		this.visita = visita;
	}

	
	
	
	// ---------------------Getters and Setters------------------------
	public int getId_consumidor() {
		return id_consumidor;
	}

	public void setId_consumidor(int id_consumidor) {
		this.id_consumidor = id_consumidor;
	}

	public Long getNr_telefone() {
		return nr_telefone;
	}

	public void setNr_telefone(Long nr_telefone) {
		this.nr_telefone = nr_telefone;
	}

	public String getNm_consumidor() {
		return nm_consumidor;
	}

	public void setNm_consumidor(String nm_consumidor) {
		this.nm_consumidor = nm_consumidor;
	}

	public String getEmail_consumidor() {
		return email_consumidor;
	}

	public void setEmail_consumidor(String email_consumidor) {
		this.email_consumidor = email_consumidor;
	}

	public String getDs_genreo() {
		return ds_genreo;
	}

	public void setDs_genreo(String ds_genreo) {
		this.ds_genreo = ds_genreo;
	}

	public Calendar getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Calendar dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public List<Visita> getVisita() {
		return visita;
	}

	public void setVisita(List<Visita> visita) {
		this.visita = visita;
	}


	// ---------------------ToString------------------------,
	
	@Override
	public String toString() {
		return "Consumidor ["
				+ "id_consumidor=" + id_consumidor
				+ ", nr_telefone=" + nr_telefone
				+ ", nm_consumidor=" + nm_consumidor
				+ ", email_consumidor=" + email_consumidor
				+ ", ds_genreo=" + ds_genreo
				+ ", dt_nascimento=" + dt_nascimento
				+ ", visita="+ visita.toString() + "]";
	}
	
	
}
