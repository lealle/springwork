package exam4;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test02_TypedQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEx01");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ts = em.getTransaction();			// 트랜잭션 관리 
	
		/*
		 * TypeQuery 클래스 : sql문을 직접 작성하고자 할 떄 (나에게 맞는 select문을 사용할떄
		 * - 일반 sql 문이 아니고 영속성의 객체에 넣을 구문 jpa 문법임
		 * select * => * 를 사용할수 없음 테이블의 별칭을 넣어줘야함
		 * */
		
		TypedQuery<Member> query = em.createQuery(
				"select m from Member4 m order by m.name",
				Member.class
				);
		List<Member> list = query.getResultList();

		if(list.isEmpty()) {
			System.out.println("DB에 회원이 없습니다.");
		}else {
			for(Member m : list ) {
				System.out.printf("EMAIL : %s  NAME : %s DATE : ",m.getEmail(),m.getName());
				
				System.out.printf("%ty/%<tm/%<td",m.getCreateDate());
				System.out.println();
			}
		}
		
		em.close();
		emf.close();
	
	}
}
