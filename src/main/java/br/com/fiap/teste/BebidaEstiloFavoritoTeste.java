package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.dao.VisitaDAO;

public class BebidaEstiloFavoritoTeste {
	public static void main(String[] args) {

		EntityManager em = null;


		//Bebida e o estilo favoritos com base no consumo
		try {

			em = Persistence.createEntityManagerFactory("challenge").createEntityManager();

			VisitaDAO dao = new VisitaDAO(em);

			System.out.println("\n----------------Bebida e o estilo favoritos com base no consumo----------------");
			
			//telefones no bd para teste: 35991028674, 27976332418 
			//cnpj no bd para teste: 80464532000119, 20779347000191
			
			for (Object[] entidade : dao.BebidaEstiloFavorito(27976332418L, 80464532000119L)) {
				
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("Cliente: " + entidade[0]);
				System.out.println("Estabelecimento: " + entidade[1]);
				System.out.println("Bebida: " + entidade[2]);
				System.out.println("tipo: " + entidade[3]);
				System.out.println("Total de pedidos: " + entidade[4]);
				
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
