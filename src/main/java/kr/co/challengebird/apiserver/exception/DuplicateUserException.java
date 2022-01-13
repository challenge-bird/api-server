package kr.co.challengebird.apiserver.exception;


public class DuplicateUserException extends RuntimeException{
	public DuplicateUserException() {
		super("이미 존재하는 유저입니다.");
	}
}
