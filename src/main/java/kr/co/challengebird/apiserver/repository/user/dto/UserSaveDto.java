package kr.co.challengebird.apiserver.repository.user.dto;

import kr.co.challengebird.apiserver.domain.user.User;
import kr.co.challengebird.apiserver.domain.user.UserRole;
import lombok.Getter;

@Getter
public class UserSaveDto {
	private String name;
	private String email;
	private String picture;

	public User toEntity() {
		return new User(name, email, picture, UserRole.USER);
	}
}
