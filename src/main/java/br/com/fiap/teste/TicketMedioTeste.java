package br.com.fiap.teste;

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

			System.out.println("\n---------------- O Ticket Medio gasto por visita ----------------");
			for (Object[] entidade : dao.TicketMedioGastoNoEstabelecimento(35991028674L, 38382013000145L)) {
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("Cliente: " + entidade[0]);
				System.out.println("Estabelecimento: " + entidade[1]);
				System.out.println("Ticket Medio gasto: " + entidade[2]);
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
