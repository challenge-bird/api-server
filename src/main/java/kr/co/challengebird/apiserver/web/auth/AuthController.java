package kr.co.challengebird.apiserver.web.auth;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.challengebird.apiserver.domain.auth.JwtRequestDto;
import kr.co.challengebird.apiserver.repository.user.dto.UserSaveDto;
import kr.co.challengebird.apiserver.service.auth.AuthService;
import kr.co.challengebird.apiserver.service.user.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("login")
	public String login(@RequestBody @Valid JwtRequestDto request) {
		return authService.login(request);
	}

	@PostMapping("/signup")
	public String signup(@RequestBody @Valid UserSaveDto request) {
		return authService.signUp(request);
	}
}
