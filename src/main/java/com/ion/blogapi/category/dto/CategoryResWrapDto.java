package com.ion.blogapi.category.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.common.dto.CommonResDto;
import com.ion.blogapi.config.ModelMapperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResWrapDto {

	CategoryResDto data;
/*
	private Long catId;
	private String catName;
	private int orderNum;
	private int depth;
	private Long blogId;
	private Long parentCatId;

	// common field
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp createdDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp modifiedDate;
*/
	CommonResDto resLog;

	{
		resLog = CommonResDto.setSuccess();
	}

//	public static CategoryResDto of(Category category) {
//		return ModelMapperUtils.getModelMapper().map(category, CategoryResWrapDto.CategoryResDtoTest.class);
//	}

	@Data
	@NoArgsConstructor
	public class CategoryResDtoTest {

		private Long catId;
		private String catName;
		private int orderNum;
		private int depth;
		private Long blogId;
		private Long parentCatId;

		// common field
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private Timestamp createdDate;
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
		private Timestamp modifiedDate;

	}
}
