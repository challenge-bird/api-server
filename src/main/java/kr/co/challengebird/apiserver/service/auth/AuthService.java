package kr.co.challengebird.apiserver.service.auth;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.challengebird.apiserver.domain.auth.JwtRequestDto;
import kr.co.challengebird.apiserver.domain.auth.UserDetailsImpl;
import kr.co.challengebird.apiserver.repository.user.dto.UserSaveDto;
import kr.co.challengebird.apiserver.service.user.UserService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

	private final UserService userService;
	private final AuthenticationManager authenticationManager;

	public String login(JwtRequestDto request) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl principal = (UserDetailsImpl)authentication.getPrincipal();
		return principal.getUsername();
	}


	public String signUp(UserSaveDto saveDto) {
		return userService.save(saveDto).getEmail();
	}


}
