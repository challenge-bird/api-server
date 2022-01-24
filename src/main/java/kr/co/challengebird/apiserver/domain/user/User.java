package kr.co.challengebird.apiserver.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Long id;

	@Column(length = 20, nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	private String password;

	private String picture;

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
}
