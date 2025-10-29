package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "JPAEx01")
public class Member1 {
	@Id 		// 테이블의 pk
	@SequenceGenerator(
			name = "mySequence1",
			sequenceName="JpaMember1_SEQ",  //실제 DB에 생성되는 시퀀스 이름 
			initialValue = 1
			
			)
	
	@GeneratedValue(generator ="mySequence1")  // 시퀀스 : 별도의 설정이 없으면 50씩 증가
	private Long id;
	private String username;
	
	@Column(name="create_date") // 컬럼명을 create_date으로 지정할 때
	private LocalDate createDate;

	public Member1() {}
	
	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
	
	
	
}
