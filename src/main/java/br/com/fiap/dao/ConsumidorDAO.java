package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Consumidor;

public class ConsumidorDAO extends GenericDAO<Consumidor, Integer> {

	public ConsumidorDAO(EntityManager em) {
		super(em);
	}
		 
}