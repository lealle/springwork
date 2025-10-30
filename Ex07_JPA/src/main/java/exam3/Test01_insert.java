package exam3;

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
			Member3 user = new Member3("tjoeun", "더조은",LocalDate.now());
			System.out.println(111);
		
			// .persist : 영속성으로 객체에 데이터 입력(메모리에 insert 해주는 부분)
			em.persist(user);
			System.out.println(222);
			
			ts.commit();
			System.out.println(333);
			System.out.println("가입 요청을 처리했습니다");
		}catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		
	}
}
