package com.ion.blogapi.user;

import javax.persistence.AttributeConverter;

public class RoleAttributeConverter implements AttributeConverter<String, Integer> {
	@Override
	public Integer convertToDatabaseColumn(String s) {
		if(s.equals("ROLE_GUEST")) return 0;
		else if(s.equals("ROLE_USER")) return 1;
		else if(s.equals("ROLE_ADMIN")) return 99;
		else {
			System.out.println("ROLE 입력 에러");
			return -1;
		}
	}

	@Override
	public String convertToEntityAttribute(Integer code) {
		if(code == 0) return "ROLE_GUEST";
		else if(code == 1) return "ROLE_USER";
		else if(code == 99) return "ROLE_ADMIN";
		else {
			System.out.println("ROLE 출력 에러");
			return "[error] role code : " + code;
		}
	}
}
