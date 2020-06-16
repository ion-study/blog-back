package com.ion.blogapi.board.domain;

import com.ion.blogapi.common.domain.CommonField;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board extends CommonField {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, updatable = false)
	private String userId;
	private String userName;
	private String subject;

	@Column(columnDefinition = "TEXT")
	private String contents;

	public void updateInformation(String subject, String contents) {
		this.subject = subject;
		this.contents = contents;
	}

}
