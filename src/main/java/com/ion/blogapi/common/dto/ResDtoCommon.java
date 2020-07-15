package com.ion.blogapi.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResDtoCommon {
	private int returnCode;
	private String returnMessage;
}
