package kr.co.challengebird.apiserver.repository.attendance;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.challengebird.apiserver.domain.attendance.Attendance;
import kr.co.challengebird.apiserver.domain.attendance.QAttendance;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class AttendanceQueryRepository {

	private final JPAQueryFactory queryFactory;

	public Optional<Attendance> findAttendanceToDayByUserId(Long userId) {

		QAttendance attendance = QAttendance.attendance;

		return null;
	}

}
