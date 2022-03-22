package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.dao.VisitaDAO;

public class UltimaVisitaEstabelecimentoTeste {

	public static void main(String[] args) {

		EntityManager em = null;

		// Qual a data da última visita ao estabelecimento?
		try {

			em = Persistence.createEntityManagerFactory("challenge").createEntityManager();

			VisitaDAO dao = new VisitaDAO(em);

			System.out.println("\nVisita:");
			///telefones no bd para teste: 35991028674, 27976332418 
			//cnpj no bd para teste: 80464532000119, 20779347000191
			for (Object[] entidade : dao.ListarDataUltimaVisita(35991028674L)) {
				System.out.println("---------------- Data da ultima Visita no estabelecimento ----------------");
				System.out.println("Cliente: " + entidade[0]);
				System.out.println("Ultima visita: " + entidade[1]);
				System.out.println("---------------------------------------------------------------------------------");

				dao.commit();
			}
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