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
	@Column(name="nr_cnpj")
	private String nrCnpj;
	
	@Column(name="id_estabelecimento", nullable = false )
	@SequenceGenerator(name="estabelecimento",sequenceName="sq_t_estabelecimento",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="estabelecimento")
	private int idEstabelecimento;
	
	@Column(name="nm_estabelecimento", length = 50, nullable = false)
	private String nmEstabelecimento;
	
	@OneToOne(mappedBy = "estabelecimentos")
    private Visita visitas;
	
	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estabelecimento(int id_estabelecimento, String nm_estabelecimento, String nr_cnpj) {
		super();
		this.idEstabelecimento = id_estabelecimento;
		this.nmEstabelecimento = nm_estabelecimento;
		this.nrCnpj = nr_cnpj;
	}

	public int getId_estabelecimento() {
		return idEstabelecimento;
	}

	public void setId_estabelecimento(int id_estabelecimento) {
		this.idEstabelecimento = id_estabelecimento;
	}

	public String getNm_estabelecimento() {
		return nmEstabelecimento;
	}

	public void setNm_estabelecimento(String nm_estabelecimento) {
		this.nmEstabelecimento = nm_estabelecimento;
	}

	public String getNr_cnpj() {
		return nrCnpj;
	}

	public void setNr_cnpj(String nr_cnpj) {
		this.nrCnpj = nr_cnpj;
	}

}
