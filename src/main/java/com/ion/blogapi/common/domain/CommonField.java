package com.ion.blogapi.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by  : woonkicho
 * Created Day : 10/01/2020
 * Modified by  :yujinsong
 * Modified Day :21/06/2020
 */

@MappedSuperclass
@Data
public abstract class CommonField implements Serializable {


	private static final long serialVersionUID = -4808539823377841033L;
	private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN, timezone = "Asia/Seoul")
	@Column( nullable = false, updatable = false)
	private Timestamp createdDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN, timezone = "Asia/Seoul")
	private Timestamp modifiedDate;


	@PrePersist
	protected void onCreate() {
		createdDate = Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
	}

	@PreUpdate
	protected void onUpdate() {
		modifiedDate = Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
	}
}
