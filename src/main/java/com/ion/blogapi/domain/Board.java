package com.ion.blogapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, updatable = false)
	private String userId;
	private String userName;
	private String subject;

	@Column(columnDefinition = "TEXT")
	private String contents;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@UpdateTimestamp
	private LocalDateTime modifiedDate;

	public void updateInformation(String subject, String contents) {
		this.subject = subject;
		this.contents = contents;
	}

}
