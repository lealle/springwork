package exam2;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BasicUse {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEx01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ts = em.getTransaction();			// 트랜잭션 관리 
	
		try {
			ts.begin();
			Member2 user = new Member2("tjoeun", "1234");
			
			// .persist : 영속성으로 객체에 데이터 입력(메모리에 insert 해주는 부분)
			em.persist(user);
			
			ts.commit();
		}catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		
	}
}
