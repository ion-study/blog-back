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

	public static CommonResDto setNotFound() {
		return CommonResDto.builder().returnCode(404).returnMessage("카테고리 중복.").build();
	}

	public static CommonResDto setDuplEmail() {
		return CommonResDto.builder().returnCode(404).returnMessage("중복 이메일 입니다.").build();
	}


}
