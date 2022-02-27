package kr.co.challengebird.apiserver.web.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.challengebird.apiserver.web.dto.ResponseDto;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello bird~!";
	}

	@GetMapping("/helloJson")
	public ResponseEntity<ResponseDto<String>> helloJson() {
		String response = "hello bird~! Json..";
		return ResponseEntity.ok(new ResponseDto(response));
	}
}
