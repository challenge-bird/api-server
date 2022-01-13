package kr.co.challengebird.apiserver.repository.user.dto;

import lombok.Getter;

@Getter
public class UserUpdateDto {

	private String name;
	private String picture;

	public UserUpdateDto(String name, String picture) {
		this.name = name;
		this.picture = picture;
	}
}
