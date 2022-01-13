package kr.co.challengebird.apiserver.service.user;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.challengebird.apiserver.domain.user.User;
import kr.co.challengebird.apiserver.repository.user.dto.UserSaveDto;
import kr.co.challengebird.apiserver.repository.user.dto.UserUpdateDto;
import kr.co.challengebird.apiserver.exception.DuplicateUserException;
import kr.co.challengebird.apiserver.exception.NoSuchUserException;
import kr.co.challengebird.apiserver.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(NoSuchUserException::new);
	}

	public Long save(UserSaveDto userSaveDto) {
		checkDuplicate(userSaveDto.getEmail());
		User saveUser = userRepository.save(userSaveDto.toEntity());
		return saveUser.getId();
	}

	public void checkDuplicate(String email) {
		Optional<User> findUser = userRepository.findByEmail(email);
		if(findUser.isPresent()) {
			throw new DuplicateUserException();
		}
	}

	public Long update(Long id, UserUpdateDto userUpdateDto) {
		User findUser = userRepository.findById(id).orElseThrow(NoSuchUserException::new);
		findUser.update(userUpdateDto);
		return findUser.getId();
	}
}
