package kr.co.challengebird.apiserver.service.attendance;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.challengebird.apiserver.domain.attendance.Attendance;
import kr.co.challengebird.apiserver.repository.attendance.AttendanceRepository;
import kr.co.challengebird.apiserver.repository.attendance.dto.AttendanceListDto;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AttendanceService {

	private final AttendanceRepository attendanceRepository;

	public List<AttendanceListDto> findAllByUserId(Long userId) {
		List<Attendance> list = attendanceRepository.findAllByUserId(userId);
		return list.stream().map(AttendanceListDto::new).collect(Collectors.toList());
	}
}
