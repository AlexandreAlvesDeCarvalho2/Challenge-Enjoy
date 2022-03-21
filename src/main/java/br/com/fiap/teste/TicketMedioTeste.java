package br.com.fiap.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.dao.VisitaDAO;

public class TicketMedioTeste {
	public static void main(String[] args) {

		EntityManager em = null;

		// o Qual é o ticket médio (valor médio gasto no estabelecimento)
		try {

			em = Persistence.createEntityManagerFactory("challenge").createEntityManager();

			VisitaDAO dao = new VisitaDAO(em);

			System.out.println("\n---------------- O Ticket Medio gasto por visita nos ultimos 365 dias----------------");
			//telefones no bd para teste: 35991028674, 27976332418 
			//cnpj no bd para teste: 80464532000119, 20779347000191
			for (BigDecimal entidade : dao.TicketMedioGastoNoEstabelecimento(27976332418L, 20779347000191L)) {
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("Ticket Medio gasto por visita: " + entidade);
				System.out.println("---------------------------------------------------------------------------------");
			}

			dao.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}
	}

}
