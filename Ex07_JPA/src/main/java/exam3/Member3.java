package exam3;

import java.time.LocalDate;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="JpaMember3")
public class Member3 {
	@Id 		// 테이블의 pk
	private String email;

	private String name;
	
	
	@Column(name="create_date")				
	private LocalDate createDate;
	
	public String getEmail() {
		return email;
	}


	public String getName() {
		return name;
	}


	public LocalDate getCreateDate() {
		return createDate;
	}


	public Member3(String email, String name, LocalDate createDate) {
		this.email = email;
		this.name = name;
		this.createDate = createDate;
	}

	public Member3() {
	}


	public void changeName(String name) {
		this.name = name;
	}
// 이렇게 안하고 setter 메소드를 사용해도 됨 
	
	
	




















}

