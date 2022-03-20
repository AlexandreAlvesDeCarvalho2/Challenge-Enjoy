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
	@Column(name="id_endereco")
    @SequenceGenerator(name="endereco",sequenceName="sq_t_endereco",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="endereco")
	private int idEndereco;
	
	@Column(name="ds_logradouro",length = 100, nullable = false)
	private String dsLogradouro;
	
	@Column(name="nr_cep", length = 8, nullable = false)
	private String nrCep;
	
	@Column(name="nr_endereco",nullable = false)
	private int nrEndereco;

	@Column(name="nm_bairro", length = 45, nullable = false)
	private String nmBairro;
	
	@Column(name="nm_cidade", length = 45, nullable = false)
	private String nmCidade;
	
	@Column(name="nm_estado", length = 45, nullable = false)
	private String nmEstado;
	
	@Column(name="ds_complemento", length = 20, nullable = false)
	private String dsComplemento;


	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(int id_endereco, String ds_logradouro, String nr_cep, int nr_endereco, String nm_bairro,
			String nm_cidade, String nm_estado, String ds_complemento) {
		super();
		this.idEndereco = id_endereco;
		this.dsLogradouro = ds_logradouro;
		this.nrCep = nr_cep;
		this.nrEndereco = nr_endereco;
		this.nmBairro = nm_bairro;
		this.nmCidade = nm_cidade;
		this.nmEstado = nm_estado;
		this.dsComplemento = ds_complemento;
	}

	public int getId_endereco() {
		return idEndereco;
	}

	public void setId_endereco(int id_endereco) {
		this.idEndereco = id_endereco;
	}

	public String getDs_logradouro() {
		return dsLogradouro;
	}

	public void setDs_logradouro(String ds_logradouro) {
		this.dsLogradouro = ds_logradouro;
	}

	public String getNr_cep() {
		return nrCep;
	}

	public void setNr_cep(String nr_cep) {
		this.nrCep = nr_cep;
	}

	public int getNr_endereco() {
		return nrEndereco;
	}

	public void setNr_endereco(int nr_endereco) {
		this.nrEndereco = nr_endereco;
	}

	public String getNm_bairro() {
		return nmBairro;
	}

	public void setNm_bairro(String nm_bairro) {
		this.nmBairro = nm_bairro;
	}

	public String getNm_cidade() {
		return nmCidade;
	}

	public void setNm_cidade(String nm_cidade) {
		this.nmCidade = nm_cidade;
	}

	public String getNm_estado() {
		return nmEstado;
	}

	public void setNm_estado(String nm_estado) {
		this.nmEstado = nm_estado;
	}

	public String getDs_complemento() {
		return dsComplemento;
	}

	public void setDs_complemento(String ds_complemento) {
		this.dsComplemento = ds_complemento;
	}
	
	

}
