package com.ion.blogapi.common.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResDto {
	private int returnCode;
	private String returnMessage;
}
