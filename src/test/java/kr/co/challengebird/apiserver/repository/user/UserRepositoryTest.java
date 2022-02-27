package kr.co.challengebird.apiserver.repository.user;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import kr.co.challengebird.apiserver.domain.user.User;
import kr.co.challengebird.apiserver.domain.user.UserRole;
import kr.co.challengebird.apiserver.exception.NoSuchUserException;

@Disabled
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("local-db")
class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	void 유저_저장_및_조회() {
		//given
		User user = new User("테스트","test@email.com","", "1234",UserRole.USER);

		//when
		User savedUser = userRepository.save(user);

		//then
		User findUser = userRepository.findByEmail(user.getEmail()).orElseThrow(NoSuchUserException::new);
		assertThat(savedUser).isEqualTo(findUser);
	}

	@Test
	void 유저_수정() {
		//given
		User user = new User("테스트","test@email.com","", "1234",UserRole.USER);
		User savedUser = userRepository.save(user);
		String updatedName = "수정테스트";
		String updatedPicture = "수정사진.png";

		//when
		savedUser.setName(updatedName);
		savedUser.setPicture(updatedPicture);


		User findUser = userRepository.findByEmail(user.getEmail()).orElseThrow(NoSuchUserException::new);

		//then
		assertThat(findUser)
			.extracting("name","picture")
			.contains(updatedName, updatedPicture);
	}
}