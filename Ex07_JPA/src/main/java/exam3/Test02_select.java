package exam3;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test02_select {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAEx01");
		EntityManager em = emf.createEntityManager();
		// select 구문이라 필요 없음 
		//EntityTransaction ts = em.getTransaction();			// 트랜잭션 관리 
	
		/*
		 * 검색시 find() 메소드 이용 
		 * - tjoeun 찾아서 Member3에 담아서 가져옴 
		 *  > 아무것도 지정하지 않으면 @Id 가 붙은 pk 를 이용하여 검색하여 가져옴 
		 * 
		 * 
		 * */
		
		System.out.println(111);
		
			// .persist : 영속성으로 객체에 데이터 입력(메모리에 insert 해주는 부분)
			Member3 user = em.find(Member3.class, "tjoeun");
			System.out.println(user);
			System.out.println(222);
			
			if(user != null) {
				System.out.println("이름 : "+user.getName());
				System.out.printf("날짜 : %ty/%<tm/%<td",user.getCreateDate());
				System.out.println();
				/*
				 *    %< 로 상대 인덱스 지정하여 직전의 인수와 같은 인덱스를 이용   
				 * ex) %tY , %tm
				 * 't' or 'T' : 날짜, 시간(날짜 및 시간 서식문자 앞에 지정)
				 * y, Y : 년도 2자리 , 4자리 
				 * m : 월 01~12
				 * d : 일 01~31
				 * e : 일 1~31 (앞에 0이 안붙는것)
				 * H : 24시간 형식의 시 00~ 23
				 * I : 12시간 형식의 시 0~11
				 * M : 분 00~59
				 * S : 초 00~59
				 * */
				
			}else {
				System.out.println("Id가 존재하지 않습니다");
				
			}
			
			System.out.println(333);
			System.out.println("가입 요청을 처리했습니다");
		
	}
}
