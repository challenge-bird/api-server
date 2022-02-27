package kr.co.challengebird.apiserver.web.hello;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
	public ResponseEntity<Map<String, Object>> helloJson() {
		Map<String, Object> response = new ConcurrentHashMap<>();
		String res = "hello bird~! Json..";
		response.put("data", res);
		return ResponseEntity.ok(response);
	}
}
