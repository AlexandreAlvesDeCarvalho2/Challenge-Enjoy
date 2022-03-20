package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_estabelecimento")
public class Estabelecimento {
	
	
	@Id
	@Column(length = 14, nullable = false, unique=true)
	private String nr_cnpj;
	
    @SequenceGenerator(name="estabelecimento",sequenceName="sq_t_estabelecimento",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="estabelecimento")
	private int id_estabelecimento;
	
	@Column(length = 50, nullable = false)
	private String nm_estabelecimento;
	
	@OneToOne(mappedBy = "estabelecimentos")
    private Visita visitas;
	
	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estabelecimento(int id_estabelecimento, String nm_estabelecimento, String nr_cnpj) {
		super();
		this.id_estabelecimento = id_estabelecimento;
		this.nm_estabelecimento = nm_estabelecimento;
		this.nr_cnpj = nr_cnpj;
	}

	public int getId_estabelecimento() {
		return id_estabelecimento;
	}

	public void setId_estabelecimento(int id_estabelecimento) {
		this.id_estabelecimento = id_estabelecimento;
	}

	public String getNm_estabelecimento() {
		return nm_estabelecimento;
	}

	public void setNm_estabelecimento(String nm_estabelecimento) {
		this.nm_estabelecimento = nm_estabelecimento;
	}

	public String getNr_cnpj() {
		return nr_cnpj;
	}

	public void setNr_cnpj(String nr_cnpj) {
		this.nr_cnpj = nr_cnpj;
	}
	
	
	

}
