package kr.co.challengebird.apiserver.service.user;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import kr.co.challengebird.apiserver.domain.user.User;
import kr.co.challengebird.apiserver.domain.user.UserRole;
import kr.co.challengebird.apiserver.exception.DuplicateUserException;
import kr.co.challengebird.apiserver.repository.user.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@InjectMocks
	UserService userService;

	@Mock
	UserRepository userRepository;


	@Test
	void 고객중복확인() {
		//given
		String email = "testEmail@email.com";
		User user = new User("",email,"","", UserRole.USER);
		given(userRepository.findByEmail(email)).willReturn(Optional.of(user));

		//when
		//then
		assertThatThrownBy(()->userService.checkDuplicate(email))
			.isInstanceOf(DuplicateUserException.class);
	}
}