package br.com.fiap.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Visita;

public class VisitaDAO extends GenericDAO<Visita, Integer> {

	public VisitaDAO(EntityManager em) {
		super(em);
	}
	
	// Listar a data da última visita ao estabelecimento
	@SuppressWarnings("unchecked")
	public List<Visita[]>ListarDataUltimaVisita(Long nr_telefone) { 
		String Query =
				
				"SELECT c.nm_consumidor, v.dt_visita FROM T_VISITA v\r\n"
				+ "join T_CONSUMIDOR c on c.nr_telefone = v.nr_telefone\r\n"
				+ "where c.nr_telefone = :nr\r\n"
				+ "order by dt_visita desc";
		
		return this.em.createNativeQuery(Query).setParameter("nr", nr_telefone).setMaxResults(1).getResultList();
	}
	
	
	// Listar frequência de visitas
	@SuppressWarnings("unchecked")
	public List<Object[]>ListarFrequenciaDeVisitas(Long nr_telefone) { 
		
		String Query =
				
				"select c.nm_consumidor, count(*) from t_visita v\r\n"
				+ "join T_CONSUMIDOR c on c.nr_telefone = v.nr_telefone\r\n"
				+ "where v.dt_visita >= (select (CURRENT_DATE - 365) from dual)\r\n"
				+ "and c.nr_telefone = :nr\r\n"
				+ "group by c.nm_consumidor";
		
		return this.em.createNativeQuery(Query).setParameter("nr", nr_telefone).getResultList();
	}
	
	// Listar ticket médio de visitas
	@SuppressWarnings("unchecked")
	public List<BigDecimal>TicketMedioGastoNoEstabelecimento(Long nr_telefone) { 
		
		String Query =
				
				"select cast(AVG(sum(vl_pedido*qt_pedido))AS NUMERIC(10,2)) as Valor_Medio_Gasto_POR_Visita from t_visita v\r\n"
				+ "join T_CONSUMIDOR c on c.nr_telefone = v.nr_telefone\r\n"
				+ "join T_PEDIDO p on p.id_visita = v.id_visita\r\n"
				+ "where v.dt_visita >= (select (CURRENT_DATE - 365) from dual)\r\n"
				+ "and c.nr_telefone = :nr\r\n"
				+ "group by v.id_visita";
		
		return this.em.createNativeQuery(Query).setParameter("nr", nr_telefone).getResultList();
	}
	
	
	// Listar bebidas estilos favorito
	@SuppressWarnings("unchecked")
	public List<Object[]>BebidaEstiloFavorito(Long nr_telefone) { 
		String Query =
				
				"select c.nm_consumidor, p.ds_produto, p.ds_tipo_produto, (SUM(QT_pedido)) as Total_Pedidos FROM t_visita v\r\n"
				+ "join T_PEDIDO p on p.id_visita = v.id_visita\r\n"
				+ "join T_CONSUMIDOR c on c.nr_telefone = v.nr_telefone\r\n"
				+ "where c.nr_telefone = :nr\r\n"
				+ "GROUP BY c.nm_consumidor, p.ds_produto, p.ds_tipo_produto, ds_tipo_produto, v.id_visita\r\n"
				+ "Order by SUM(QT_pedido) desc";
		
		return this.em.createNativeQuery(Query).setParameter("nr", nr_telefone).setMaxResults(3).getResultList();
	}
	
	
}





