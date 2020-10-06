package com.ion.blogapi.user;

import com.ion.blogapi.common.dto.CommonResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public CommonResDto setUser(User user) {
		// email 중복 검사
		System.out.println("중복검사 시작");
		System.out.println(userRepository.findByEmail(user.getEmail()));
		if(userRepository.findByEmail(user.getEmail()) != null) {
			return CommonResDto.setDuplEmail();
		}
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

	@Transactional
	public CommonResDto updateUser(User user) {
		User oldUser = userRepository.findByEmail(user.getEmail());
		System.out.println(oldUser);

		// user 존재하는지 판단
		if(oldUser == null) {
			System.out.println("User 가 존재하지 않습니다.");
			return null;
		}

		// db update
		oldUser.setName(user.getName());
		oldUser.setPassword(user.getPassword());
		userRepository.save(oldUser);

		System.out.println("new user:");
		System.out.println(oldUser);

		// Entity To Dto
		return CommonResDto.builder().returnCode(200).returnMessage("success").build();
	}

	public CommonResDto deleteUser(String email) {
		User user = userRepository.findByEmail(email);
		user.setRole(Role.GUEST.getKey());
		userRepository.save(user);

		// Entity To Dto
		return CommonResDto.builder().returnCode(200).returnMessage("success").build();
	}
}
