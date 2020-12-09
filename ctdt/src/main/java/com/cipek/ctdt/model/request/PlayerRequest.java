package com.cipek.ctdt.model.request;

import java.util.List;

import com.cipek.ctdt.model.request.dto.PlayerRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PlayerRequest {

	private List<PlayerRequestDto> playerList;
	
	public PlayerRequest() {
		
	}
}
