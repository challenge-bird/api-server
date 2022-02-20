package kr.co.challengebird.apiserver.service.attendance;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.challengebird.apiserver.domain.attendance.Attendance;
import kr.co.challengebird.apiserver.domain.user.User;
import kr.co.challengebird.apiserver.exception.DuplicateAttendanceException;
import kr.co.challengebird.apiserver.exception.NoSuchUserException;
import kr.co.challengebird.apiserver.repository.attendance.AttendanceQueryRepository;
import kr.co.challengebird.apiserver.repository.attendance.AttendanceRepository;
import kr.co.challengebird.apiserver.repository.attendance.dto.AttendanceListDto;
import kr.co.challengebird.apiserver.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AttendanceService {

	private final AttendanceRepository attendanceRepository;

	private final AttendanceQueryRepository attendanceQueryRepository;

	private final UserRepository userRepository;

	/*
	* 유저의 전체 출석내역 호출
	* */
	public List<AttendanceListDto> findAllByUserId(Long userId) {
		List<Attendance> list = attendanceRepository.findAllByUserId(userId);
		return list.stream().map(AttendanceListDto::new).collect(Collectors.toList());
	}

	/*
	* 오늘 출석 조회
	* */
	public Long toDayAttendanceCheck(Long userId) {
		User findUser = userRepository.findById(userId).orElseThrow(NoSuchUserException::new);
		Attendance attendance = new Attendance(findUser);
		Attendance savedAttendance = attendanceRepository.save(attendance);
		return savedAttendance.getId();
	}

	/*
	* 오늘 출석이 중복됬는지 확인
	* */
	public void validDuplicatedAttendanceCheckToday(Long userId) {
		Optional<Attendance> findAttendance = attendanceQueryRepository.findAttendanceToDayByUserId(userId);
		if(findAttendance.isPresent()) {
			throw new DuplicateAttendanceException();
		}
	}
}
