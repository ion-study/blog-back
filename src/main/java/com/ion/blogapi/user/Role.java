package com.ion.blogapi.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
	GUEST(0, "ROLE_GUEST"), // 손님
	USER(1, "ROLE_USER"),   // 사용자
	ADMIN(99, "ROLE_ADMIN"); // 어드민

	private final int number;
	private final String key;
}
