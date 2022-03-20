package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Visita;

public class VisitaDAO extends GenericDAO<Visita, Integer> {

	public VisitaDAO(EntityManager em) {
		super(em);
	}
	
	// Listar a data da última visita ao estabelecimento
	@SuppressWarnings("unchecked")
	public List<Object[]>ListarDataUltimaVisita(Long nr_telefone, Long nrCnpj) { 
		String Query =
				
				"SELECT * FROM (SELECT c.nm_consumidor, e.nm_estabelecimento, v.dt_visita FROM T_VISITA v\r\n"
				+ "join T_CONSUMIDOR c on c.nr_telefone = v.nr_telefone\r\n"
				+ "join T_ESTABELECIMENTO e on e.nr_cnpj = v.nr_cnpj\r\n"
				+ "where c.nr_telefone = :nr \r\n"
				+ "and e.nr_cnpj = :nr_cnpj)\r\n"
				+ "WHERE ROWNUM = 1\r\n"
				+ "order by dt_visita desc";
		
		return this.em.createNativeQuery(Query).setParameter("nr", nr_telefone).setParameter("nr_cnpj", nrCnpj).getResultList();
	}
	
	
	// Listar frequência de visitas
	@SuppressWarnings("unchecked")
	public List<Object[]>ListarFrequenciaDeVisitas(Long nr_telefone, Long nrCnpj) { 
		
		String Query =
				
				"select c.nm_consumidor,e.nm_estabelecimento, count(*) from t_visita v\r\n"
				+ "join T_CONSUMIDOR c on c.nr_telefone = v.nr_telefone\r\n"
				+ "join T_ESTABELECIMENTO e on e.nr_cnpj = v.nr_cnpj\r\n"
				+ "where v.dt_visita > (select (CURRENT_DATE - 365) from dual)\r\n"
				+ "and c.nr_telefone = :nr \r\n"
				+ "and e.nr_cnpj = :nr_cnpj\r\n"
				+ "group by c.nm_consumidor, e.nm_estabelecimento";
		
		return this.em.createNativeQuery(Query).setParameter("nr", nr_telefone).setParameter("nr_cnpj", nrCnpj).getResultList();
	}
	
	// Listar ticket médio de visitas
	@SuppressWarnings("unchecked")
	public List<Object[]>TicketMedioGastoNoEstabelecimento(Long nr_telefone, Long nrCnpj) { 
		
		String Query =
				
				"select c.nm_consumidor, e.nm_estabelecimento, AVG(vlr_total) from t_visita v\r\n"
				+ "join T_CONSUMIDOR c on c.nr_telefone = v.nr_telefone\r\n"
				+ "join T_ESTABELECIMENTO e on e.nr_cnpj = v.nr_cnpj\r\n"
				+ "where dt_visita > (select (CURRENT_DATE - 365) from dual)\r\n"
				+ "and c.nr_telefone = :nr \r\n"
				+ "and e.nr_cnpj = :nr_cnpj group by c.nm_consumidor, e.nm_estabelecimento";
		
		return this.em.createNativeQuery(Query).setParameter("nr", nr_telefone).setParameter("nr_cnpj", nrCnpj).getResultList();
	}
	
	
	// Listar ticket médio de visitas
	@SuppressWarnings("unchecked")
	public List<Object[]>BebidaEstiloFavorito(Long nr_telefone, Long nrCnpj) { 
		String Query =
				
				"select c.nm_consumidor, e.nm_estabelecimento, ds_produto, ds_tipo_produto, SUM(QT_pedido) as Total_Pedidos FROM t_visita v \r\n"
				+ "join T_PEDIDO p on p.id_visita = v.id_visita\r\n"
				+ "join T_CONSUMIDOR c on c.nr_telefone = v.nr_telefone\r\n"
				+ "join T_ESTABELECIMENTO e on e.nr_cnpj = v.nr_cnpj\r\n"
				+ "where c.nr_telefone = :nr and e.nr_cnpj = :nr_cnpj\r\n"
				+ "GROUP BY c.nm_consumidor, p.ds_produto, p.ds_tipo_produto, e.nm_estabelecimento\r\n"
				+ "Order by SUM(QT_pedido) desc";
		
		return this.em.createNativeQuery(Query).setParameter("nr", nr_telefone).setParameter("nr_cnpj", nrCnpj).getResultList();
	}
	
	
}





