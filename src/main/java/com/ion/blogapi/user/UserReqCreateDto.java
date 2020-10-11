package com.ion.blogapi.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserReqCreateDto {
	@NotBlank(message = "메일을 작성해주세요.")
	@Email(message = "email을 올바르게 입력하세요.")
	private String email;

	@NotBlank(message = "이름은 필수 입력값 입니다.")
	private String name;

	@NotBlank(message = "비밀번호는 필수 입력값 입니다.")
	private String password;

	@NotBlank(message = "권한은 필수 입력값 입니다.")
	private String role;
}