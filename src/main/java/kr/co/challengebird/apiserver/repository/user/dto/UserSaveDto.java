package kr.co.challengebird.apiserver.repository.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.crypto.password.PasswordEncoder;

import kr.co.challengebird.apiserver.domain.user.User;
import kr.co.challengebird.apiserver.domain.user.UserRole;
import lombok.Getter;

@Getter
public class UserSaveDto {

	@NotEmpty
	private String name;

	@Email
	private String email;

	private String password;

	private String picture;

	public User toEntity(PasswordEncoder passwordEncoder) {
		String enPassword = passwordEncoder.encode(password);
		return new User(name, email, picture, enPassword, UserRole.USER);
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
