package kr.co.challengebird.apiserver.web.dto;


public class ResponseDto<T> {
	private final T data;

	public ResponseDto(T data) {
		this.data = data;
	}
}
