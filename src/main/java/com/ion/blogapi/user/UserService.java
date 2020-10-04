package com.ion.blogapi.user;

import com.ion.blogapi.common.dto.CommonResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public CommonResDto setUser(User user) {
		userRepository.save(user);
		return CommonResDto.setSuccess();
	}

	public User getUser(String email) {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			// 예외처리
			System.out.println("[Error] 적절한 사용자가 없습니다.");
			return null;
		}else {
			return userRepository.findByEmail(email);
		}
	}
}
