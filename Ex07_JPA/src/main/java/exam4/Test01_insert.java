package exam4;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test01_insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEx01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ts = em.getTransaction();			// 트랜잭션 관리 
	
		try {
			ts.begin();
			// 1
			Member user1 = new Member("test1@tjoeun.com", "이한나", LocalDate.now());
			em.persist(user1);

			// 2
			Member user2 = new Member("test2@tjoeun.com", "김철수", LocalDate.now());
			em.persist(user2);

			// 3
			Member user3 = new Member("test3@tjoeun.com", "박영희", LocalDate.now());
			em.persist(user3);

			// 4
			Member user4 = new Member("test4@tjoeun.com", "최민준", LocalDate.now());
			em.persist(user4);

			// 5
			Member user5 = new Member("test5@tjoeun.com", "정수빈", LocalDate.now());
			em.persist(user5);

			// 6
			Member user6 = new Member("test6@tjoeun.com", "윤지우", LocalDate.now());
			em.persist(user6);

			// 7
			Member user7 = new Member("test7@tjoeun.com", "강현우", LocalDate.now());
			em.persist(user7);

			// 8
			Member user8 = new Member("test8@tjoeun.com", "송예은", LocalDate.now());
			em.persist(user8);

			// 9
			Member user9 = new Member("test9@tjoeun.com", "임도윤", LocalDate.now());
			em.persist(user9);

			// 10
			Member user10 = new Member("test10@tjoeun.com", "한지민", LocalDate.now());
			em.persist(user10);
			
			
			
			ts.commit();
			System.out.println("가입 요청을 처리했습니다");
		}catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		em.close();
		emf.close();
		
	}
}
