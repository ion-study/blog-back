package com.ion.blogapi.user;
import com.ion.blogapi.common.dto.CommonResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
