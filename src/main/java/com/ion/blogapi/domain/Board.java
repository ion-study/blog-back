package com.ion.blogapi.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {

	@Id
	@GeneratedValue
	private Long id;
	private String writer;
	private String content;

}
