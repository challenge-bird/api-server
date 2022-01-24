package kr.co.challengebird.apiserver.repository.attendance.dto;

import java.time.format.DateTimeFormatter;

import kr.co.challengebird.apiserver.domain.attendance.Attendance;
import lombok.Getter;

@Getter
public class AttendanceListDto {
	public String checkDateTime;

	private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	public AttendanceListDto(Attendance attendance) {
		this.checkDateTime = attendance.getCheckDateTimeStr();
	}
}
