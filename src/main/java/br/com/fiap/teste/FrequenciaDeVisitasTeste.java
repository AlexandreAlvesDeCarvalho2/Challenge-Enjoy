package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.dao.VisitaDAO;

public class FrequenciaDeVisitasTeste {
	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("challenge").createEntityManager();

			VisitaDAO dao = new VisitaDAO(em);

			System.out.println(
					
					"\n---------------- Qual é a frequência de visitas nos ultimos 365 dias no estabelecimento? ----------------");
			//telefones no bd para teste: 35991028674, 27976332418 
			//cnpj no bd para teste: 80464532000119, 20779347000191
			for (Object[] entidade : dao.ListarFrequenciaDeVisitas(35991028674L)) {
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("Cliente: " + entidade[0]);
				System.out.println("Frequencia: " + entidade[1] + "x nos ultimos 365 dias");
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
