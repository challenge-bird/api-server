package kr.co.challengebird.apiserver.exception;

public class DuplicateAttendanceException extends RuntimeException {
	public DuplicateAttendanceException() {
		super("이미 출석하였습니다.");
	}
}
