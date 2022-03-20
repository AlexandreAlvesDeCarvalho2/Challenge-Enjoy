package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_endereco")
public class Endereco {
	
	@Id
    @SequenceGenerator(name="endereco",sequenceName="sq_t_endereco",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="endereco")
	private int id_endereco;
	
	@Column(length = 100, nullable = false)
	private String ds_logradouro;
	
	@Column(length = 8, nullable = false)
	private String nr_cep;
	
	@Column(nullable = false)
	private int nr_endereco;

	@Column(length = 45, nullable = false)
	private String nm_bairro;
	
	@Column(length = 45, nullable = false)
	private String nm_cidade;
	
	@Column(length = 45, nullable = false)
	private String nm_estado;
	
	@Column(length = 20, nullable = false)
	private String ds_complemento;


	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(int id_endereco, String ds_logradouro, String nr_cep, int nr_endereco, String nm_bairro,
			String nm_cidade, String nm_estado, String ds_complemento) {
		super();
		this.id_endereco = id_endereco;
		this.ds_logradouro = ds_logradouro;
		this.nr_cep = nr_cep;
		this.nr_endereco = nr_endereco;
		this.nm_bairro = nm_bairro;
		this.nm_cidade = nm_cidade;
		this.nm_estado = nm_estado;
		this.ds_complemento = ds_complemento;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getDs_logradouro() {
		return ds_logradouro;
	}

	public void setDs_logradouro(String ds_logradouro) {
		this.ds_logradouro = ds_logradouro;
	}

	public String getNr_cep() {
		return nr_cep;
	}

	public void setNr_cep(String nr_cep) {
		this.nr_cep = nr_cep;
	}

	public int getNr_endereco() {
		return nr_endereco;
	}

	public void setNr_endereco(int nr_endereco) {
		this.nr_endereco = nr_endereco;
	}

	public String getNm_bairro() {
		return nm_bairro;
	}

	public void setNm_bairro(String nm_bairro) {
		this.nm_bairro = nm_bairro;
	}

	public String getNm_cidade() {
		return nm_cidade;
	}

	public void setNm_cidade(String nm_cidade) {
		this.nm_cidade = nm_cidade;
	}

	public String getNm_estado() {
		return nm_estado;
	}

	public void setNm_estado(String nm_estado) {
		this.nm_estado = nm_estado;
	}

	public String getDs_complemento() {
		return ds_complemento;
	}

	public void setDs_complemento(String ds_complemento) {
		this.ds_complemento = ds_complemento;
	}
	
	

}
