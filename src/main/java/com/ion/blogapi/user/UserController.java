package com.ion.blogapi.user;
import com.ion.blogapi.common.dto.CommonResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* User Controller */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// 1. User list
	@GetMapping("/users")
	public List<User> list() {

		return null;
	}
	// 2. User create -> 회원 가입
	@PostMapping("/users")
	public CommonResDto create(@RequestBody User resource) {
		System.out.println("user : ");
		System.out.println(resource);
		System.out.println(resource.isAdmin());

		return userService.setUser(resource);

	}

	// 3. User update
	// 4. User delete -> level:0 -> 아무것도 못 함.
	//    (0:권한중지, 1:사용자, 2:블로그 주인, 3:어드민)

}
