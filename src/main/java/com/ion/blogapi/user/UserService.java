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
}
