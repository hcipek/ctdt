package com.cipek.ctdt.model.request;

import java.util.List;

import com.cipek.ctdt.model.request.dto.TypeRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class TypeRequest {

	private List<TypeRequestDto> typeList;
	
	public TypeRequest() {
		
	}
}
