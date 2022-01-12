package kr.co.challengebird.apiserver.domain.user;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import kr.co.challengebird.apiserver.domain.user.UserRole;

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20, nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	private String picture;

	private UserRole userRole;

}
