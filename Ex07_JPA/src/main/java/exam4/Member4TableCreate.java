package exam4;

import java.time.LocalDate;

import exam3.Member3;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Member4TableCreate {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEx01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ts = em.getTransaction();			// 트랜잭션 관리 
	
		em.close();
		emf.close();
		
	}

}
