package com.ion.blogapi.user;
import com.ion.blogapi.common.dto.CommonResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/* User Controller */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// 1. User list
//	@GetMapping("/users")
//	public List<User> list() {
//
//		return null;
//	}

	@GetMapping("/users")
	public User detail(@RequestParam("email") String email) {
		System.out.println(userService.getUser(email));
		return userService.getUser(email);
	}

	@PostMapping("/users")
	public CommonResDto create(@RequestBody @Valid UserReqCreateDto userReqDto, BindingResult result) {
		//validation 에러 발생 시
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				FieldError f = (FieldError) error;
				System.out.println(("error:" + f.getField() + ", " + f.getDefaultMessage()));
			}
			return CommonResDto.setReqInValid();
		}
		System.out.println("userReqDto : ");
		System.out.println(userReqDto);

		return userService.join(userReqDto);
	}

	@PatchMapping("/users")
	public CommonResDto update(@RequestBody User resource) {
		System.out.println("[update] user : ");
		System.out.println(resource);

		return userService.updateUser(resource);
	}


	// 4. User delete -> level:0 -> 아무것도 못 함.
	//    (0:권한중지, 1:사용자, 2:블로그 주인, 3:어드민)
	@DeleteMapping("/users")
	public CommonResDto delete(@RequestParam("email") String email) {
		return userService.deleteUser(email);
	}

}
