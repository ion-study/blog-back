package com.ion.blogapi.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.search.annotations.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by  : woonkicho
 * Created Day : 10/01/2020
 * Modified by  :
 * Modified Day :
 */

@MappedSuperclass
@Data
public abstract class CommonField implements Serializable {


	private static final long serialVersionUID = -4808539823377841033L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@Column( name = "create_date", nullable = false, updatable = false)
	private Timestamp createdDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp modifiedDate;


	@PrePersist
	protected void onCreate() {
		createdDate = Timestamp.valueOf(LocalDateTime.now());
	}

	@PreUpdate
	protected void onUpdate() {
		modifiedDate = Timestamp.valueOf(LocalDateTime.now());
	}
}
