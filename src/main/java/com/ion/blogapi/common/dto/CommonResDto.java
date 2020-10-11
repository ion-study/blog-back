package com.ion.blogapi.common.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResDto {
	private int returnCode;
	private String returnMessage;

	public static CommonResDto setSuccess() {
		return CommonResDto.builder().returnCode(200).returnMessage("success").build();
	}

	public static CommonResDto setDuplCategory() {
		return CommonResDto.builder().returnCode(404).returnMessage("카테고리 중복.").build();
	}

	/**
	 * User Error Code
	 * @return CommonResDto
	 */
	public static CommonResDto setDuplEmail() {
		return CommonResDto.builder().returnCode(404).returnMessage("중복 이메일 입니다.").build();
	}

	public static CommonResDto setNotFoundUser() {
		return CommonResDto.builder().returnCode(404).returnMessage("존재하지 않는 User 입니다.").build();
	}

	public static CommonResDto setReqInValid() {
		return CommonResDto.builder().returnCode(404).returnMessage("Request 유효한 값이 아닙니다.").build();
	}


}
