package kr.co.challengebird.apiserver.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.challengebird.apiserver.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
