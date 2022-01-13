package kr.co.challengebird.apiserver.exception;


public class NoSuchUserException extends RuntimeException{
	public NoSuchUserException() {
		super("고객정보가 없습니다.");
	}
}
