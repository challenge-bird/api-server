package kr.co.challengebird.apiserver.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.challengebird.apiserver.domain.auth.UserDetailsImpl;
import kr.co.challengebird.apiserver.domain.user.User;
import kr.co.challengebird.apiserver.exception.NoSuchUserException;
import kr.co.challengebird.apiserver.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username).orElseThrow(NoSuchUserException::new);
		return new UserDetailsImpl(user);
	}
}
