package kr.co.challengebird.apiserver.domain.auth;

import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequestDto {
	@Email
	private String email;
	private String password;
}
