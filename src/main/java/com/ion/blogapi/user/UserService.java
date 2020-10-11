package com.ion.blogapi.user;

import com.ion.blogapi.common.dto.CommonResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * 회원가입
	 * @param userReqDto
	 * @return CommonResDto
	 */
	public CommonResDto join(UserReqCreateDto userReqDto) {

		// 1. DTO to Entity
		User user = User.of(userReqDto);

		// email 중복 검사
		if(!validateDuplicateUser(user)) return CommonResDto.setDuplEmail();
		userRepository.save(user);
		return CommonResDto.setSuccess();
	}

	private boolean validateDuplicateUser(User user) {
		User findUser = userRepository.findByEmail(user.getEmail());
		return (findUser == null) ? true : false;
		//	throw new IllegalStateException("이미 존재하는 회원입니다.");
	}

	/**
	 * 단일 회원 조회
	 * @param email
	 * @return User
	 */
	public User getUser(String email) {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			// 예외처리
			System.out.println("[Error] 적절한 사용자가 없습니다.");
			return null;
		}else {
			return user;
		}
	}

	@Transactional
	public CommonResDto updateUser(User user) {
		// 기존 유저 검사
		if(user.getId() == null) return CommonResDto.setNotFoundUser();

		User oldUser = userRepository.findById(user.getId()).orElse(null);
		if(oldUser == null) return CommonResDto.setNotFoundUser();

		// 기존 유저 + 수정 항목 업데이트
		userRepository.save(user);

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
