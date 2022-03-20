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
	
	@Column(length = 12, nullable = false)
	@SequenceGenerator(name = "consumidor", sequenceName = "sq_t_consumidor", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumidor")
	private int id_consumidor;
	
	@Id
	@Column(name="nr_telefone", length = 12, nullable = false)
	private Long nrTelefone;

	@Column(name="nm_consumidor",nullable = false, length = 100)
	private String nmConsumidor;

	@Column(name="email_consumidor",nullable = false, length = 40)
	private String emailConsumidor;
	
	@Column(name="ds_genreo",length = 12, nullable = false)
	private String dsGenreo;

	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dtNascimento;

	
	
	// --------------------- relações------------------------
	@OneToMany(mappedBy = "visitas")
	private List<Visita> visita;
	
	

	// --------------------- Construtores------------------------
	public Consumidor() {}

	public Consumidor(int id_consumidor, Long nr_telefone, String nm_consumidor, String email_consumidor,
			String ds_genreo, Calendar dt_nascimento, List<Visita> visita) {
		super();
		this.id_consumidor = id_consumidor;
		this.nrTelefone = nr_telefone;
		this.nmConsumidor = nm_consumidor;
		this.emailConsumidor = email_consumidor;
		this.dsGenreo = ds_genreo;
		this.dtNascimento = dt_nascimento;
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
		return nrTelefone;
	}

	public void setNr_telefone(Long nr_telefone) {
		this.nrTelefone = nr_telefone;
	}

	public String getNm_consumidor() {
		return nmConsumidor;
	}

	public void setNm_consumidor(String nm_consumidor) {
		this.nmConsumidor = nm_consumidor;
	}

	public String getEmail_consumidor() {
		return emailConsumidor;
	}

	public void setEmail_consumidor(String email_consumidor) {
		this.emailConsumidor = email_consumidor;
	}

	public String getDs_genreo() {
		return dsGenreo;
	}

	public void setDs_genreo(String ds_genreo) {
		this.dsGenreo = ds_genreo;
	}

	public Calendar getDt_nascimento() {
		return dtNascimento;
	}

	public void setDt_nascimento(Calendar dt_nascimento) {
		this.dtNascimento = dt_nascimento;
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
				+ ", nr_telefone=" + nrTelefone
				+ ", nm_consumidor=" + nmConsumidor
				+ ", email_consumidor=" + emailConsumidor
				+ ", ds_genreo=" + dsGenreo
				+ ", dt_nascimento=" + dtNascimento
				+ ", visita="+ visita.toString() + "]";
	}
	
	
}
