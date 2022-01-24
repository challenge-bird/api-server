package kr.co.challengebird.apiserver.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import kr.co.challengebird.apiserver.domain.attendance.Attendance;
import kr.co.challengebird.apiserver.domain.user.UserRole;
import kr.co.challengebird.apiserver.repository.user.dto.UserUpdateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(length = 20, nullable = false)
	private String name;

	@Column(nullable = false, unique = true, updatable = false)
	private String email;

	private String password;

	private String picture;

	@Enumerated(EnumType.STRING)
	private UserRole userRole;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Attendance> attendanceList = new ArrayList<>();

	public User(String name, String email, String picture, String password, UserRole userRole) {
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.userRole = userRole;
		this.password = password;
	}

	public void update(UserUpdateDto dto) {
		name = dto.getName();
		picture = dto.getPicture();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
