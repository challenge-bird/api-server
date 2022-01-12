package kr.co.challengebird.apiserver.repository.attendance;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.challengebird.apiserver.domain.attendance.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
