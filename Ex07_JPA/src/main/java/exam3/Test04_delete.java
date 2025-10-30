package exam3;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test04_delete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEx01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ts = em.getTransaction();			// 트랜잭션 관리 
	
/*
 * 	hHibernate -> DB가 아닌 자바에 내장되어있기에 일단 데이터 잘 들어왔는지 select 로 체크한 뒤 update 구문을 실행해야 한다 
 * 
 * */		
		
		try {
			ts.begin();
			System.out.println(111);
		
			// .persist : 영속성으로 객체에 데이터 입력(메모리에 insert 해주는 부분)
			Member3 user = em.find(Member3.class, "tjoeun");
			
			if(user == null) {
				System.out.println(111);
				System.out.println("id를 찾을 수 없습니다.");
				return;
			}
			em.remove(user); // 영속성의 객체를 삭제
			
			System.out.println(222);
			
			ts.commit();
			System.out.println("탈퇴처리 되었습니다");
		}catch (Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		
	}
}
