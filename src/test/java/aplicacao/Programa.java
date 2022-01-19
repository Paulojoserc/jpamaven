package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domino.Pessoa;

public class Programa {

	public static void main(String[] args) {
	
		//entrda de dados
		 
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Maria da Silva", "maria@gmail.com");
		Pessoa p3 = new Pessoa(null, "João da Silva", "joao@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");		
		EntityManager em = emf.createEntityManager();
		//Imprimir os dados de entrda
		
		em.getTransaction().begin(); //inicia uma comunicação com o banco
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit(); ///escreve no banco
		
		
		//Busca no banco pelo id
		/*
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		*/
		
		//Removendo usuario
		/*
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		*/
		System.out.println("Pronto!");
		em.close();
		emf.close();
		
	}

}
