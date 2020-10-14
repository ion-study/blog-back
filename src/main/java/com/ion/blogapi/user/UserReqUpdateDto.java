package com.ion.blogapi.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserReqUpdateDto {
	@NotNull(message = "ID는 필수 입력값 입니다.")
	private Long id;

	private String name;

	private String password;

	private String role;
}