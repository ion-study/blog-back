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
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CategoryResDto {
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

	CommonResDto resLog;

	{
		resLog = CommonResDto.setSuccess();
	}

	public static CategoryResDto of(Category category) {
		return ModelMapperUtils.getModelMapper().map(category, CategoryResDto.class);
	}

	public static List<CategoryResDto> of(List<Category> categories) {
		List<CategoryResDto> dtoList = categories.stream()
				.map(board -> CategoryResDto.of(board))
				.collect(Collectors.toList());

		return dtoList;
	}
}
