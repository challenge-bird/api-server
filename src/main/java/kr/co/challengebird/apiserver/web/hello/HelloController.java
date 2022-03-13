package kr.co.challengebird.apiserver.web.hello;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/helloPost")
	public ResponseEntity<Map<String, Object>> helloJson(@RequestBody Map<String, Object> param) {
		String test = String.valueOf(param.get("test"));

		test += " post bird~!!!! 자동빌드설정테스트트트";

		param.put("test",test);
		return ResponseEntity.ok(param);
	}
}
