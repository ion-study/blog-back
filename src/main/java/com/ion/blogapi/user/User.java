package com.ion.blogapi.user;

import com.ion.blogapi.common.domain.CommonField;
import com.ion.blogapi.config.ModelMapperUtils;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.ObjectUtils;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

/* User Domain */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Builder
@SequenceGenerator(
		name = "USER_SEQ_GENERATOR",
		sequenceName = "USER_SEQUENCE", // 매핑할 데이터베이스 시퀀스 이름
		allocationSize = 1)
public class User extends CommonField {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "USER_SEQ_GENERATOR")
	private Long id;

	@Column(insertable = false)
	private String email;

	private String name;

	private String password;

	@Convert(converter = RoleAttributeConverter.class)
	private String role;
/*
	public static User of(UserReqCreateDto userReqDto) {
		// 이름이 같은 필드명끼리는 ModelMapper를 통해 매핑
		User user = ModelMapperUtils.getModelMapper().map(userReqDto, User.class);

		// 이름이 다른 필드는 직접 set을 통해 매핑
		// ...

		//test
		System.out.println("userReqDto to User");
		System.out.println(userReqDto);
		System.out.println(user);

		return user;
	}
*/
	public static User of(Object userReqDto) {
		// 타입 체크
		if(!(userReqDto instanceof UserReqCreateDto || userReqDto instanceof UserReqUpdateDto))
			throw new ClassCastException();

		// 이름이 같은 필드명끼리는 ModelMapper를 통해 매핑
		User user = ModelMapperUtils.getModelMapper().map(userReqDto, User.class);

		// 이름이 다른 필드는 직접 set을 통해 매핑
		// ...

		//test
		System.out.println("userReqDto to User");
		System.out.println(userReqDto);
		System.out.println(user);

		return user;
	}

	public boolean isAdmin() {
		return this.getRole().equals(Role.ADMIN.getKey());
	}

	public void updateInfo(User user) {
		if(user == null)
			throw new IllegalArgumentException("User가 NULL 입니다.");

		if(!ObjectUtils.isEmpty(user.getName()))
			this.name = user.getName();

		if(!ObjectUtils.isEmpty(user.getPassword()))
			this.password = user.getPassword();

		if(!ObjectUtils.isEmpty(user.getRole()))
		this.password = user.getPassword();

		if(!ObjectUtils.isEmpty(user.getRole()))
			this.password = user.getRole();
	}
}