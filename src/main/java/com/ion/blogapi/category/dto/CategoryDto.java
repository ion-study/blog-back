package com.ion.blogapi.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class CategoryDto {

	@Getter
	@Setter
	public static class CreateReq {
		private String catName;
		private int orderNum;
		private int depth;
		private long blogId;
		private long parentCatId;

		@Builder
		public CreateReq(String catName, int orderNum, int depth, long blogId, long parentCatId) {
			this.catName = catName;
			this.orderNum = orderNum;
			this.depth = depth;
			this.blogId = blogId;
			this.parentCatId = parentCatId;
		}
	}
}
