package kr.co.challengebird.apiserver.web.attendance;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.challengebird.apiserver.repository.attendance.dto.AttendanceListDto;
import kr.co.challengebird.apiserver.service.attendance.AttendanceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AttendanceController {

	private final AttendanceService attendanceService;

	@GetMapping("/api/v1/attendance/{userId}")
	public List<AttendanceListDto> list(@PathVariable("userId") Long userId) {
		return attendanceService.findAllByUserId(userId);
	}

	@PostMapping("/api/v1/attendance/{userId}")
	public Long toDayCheck(@PathVariable("userId") Long userId) {
		return attendanceService.toDayAttendanceCheck(userId);
	}

}
