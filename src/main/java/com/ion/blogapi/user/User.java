package com.ion.blogapi.user;

import com.ion.blogapi.common.domain.CommonField;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/* User Domain */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Builder
@SequenceGenerator(
		name = "USER_SEQ_GENERATOR",
		sequenceName = "USER_SEQ", // 매핑할 데이터베이스 시퀀스 이름
		allocationSize = 1)
public class User extends CommonField {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "USER_SEQ_GENERATOR")
	private Long id;

	@NotEmpty
	private String email;

	@NotEmpty
	private String name;

	@NotEmpty
	private String password;

	@NotNull
	@Convert(converter = RoleAttributeConverter.class)
	private String role;

	public boolean isAdmin() {
		return this.getRole().equals(Role.ADMIN.getKey());
	}
}