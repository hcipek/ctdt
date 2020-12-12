package com.cipek.ctdt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipek.ctdt.model.player.Player;
import com.cipek.ctdt.model.relation.SkillCard;
import com.cipek.ctdt.model.request.PlayerRequest;
import com.cipek.ctdt.model.request.dto.PlayerRequestDto;
import com.cipek.ctdt.model.request.dto.SkillSetDto;
import com.cipek.ctdt.model.request.dto.StatCardDto;
import com.cipek.ctdt.model.request.dto.TeamSkillDto;
import com.cipek.ctdt.model.response.PlayerResponse;
import com.cipek.ctdt.model.type.ColorType;
import com.cipek.ctdt.model.type.NationType;
import com.cipek.ctdt.model.type.TeamType;
import com.cipek.ctdt.repository.PlayerRepository;

@Service
public class PlayerService extends BaseService<Player, PlayerRepository> {
	
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private TeamSkillService teamSkillService;
	
	public PlayerResponse createNewPlayer(PlayerRequest request) {
		PlayerResponse response = new PlayerResponse();
		for(PlayerRequestDto dto : request.getPlayerList()) {
			Player player = createPlayerByDto(dto);
			save(player);
		}
		return response;
	}
	
	private Player createPlayerByDto(PlayerRequestDto dto) {
		Player player = new Player();
		player.setName(dto.getName());
		player.setTitle(dto.getTitle());
		player.setColorType(typeService.getByName(ColorType.class, dto.getColor()));
		player.setNation(typeService.getByName(NationType.class, dto.getPlayerNationName()));
		player.setTeam(typeService.getByName(TeamType.class, dto.getPlayerTeamName()));
		player.setSkillCard(createSkillCard(dto.getSkillSet()));
		player.setTeamSkill(teamSkillService.createOrGetTeamSkill(dto.getTeamSkill()));
		
		player = fillStats(dto.getStats(), player);
		
		return player;
	}
	
	private SkillCard createSkillCard(SkillSetDto dto) {
		SkillCard card = new SkillCard();
		return card;
	}
	
	private Player fillStats(StatCardDto dto, Player player) {
		player.setStamina(dto.getSta_());
		player.setDribble(dto.getDri_());
		player.setShot(dto.getSho_());
		player.setPass(dto.getPas_());
		player.setTackle(dto.getTac_());
		player.setBlock(dto.getBlo_());
		player.setIntercept(dto.getInt_());
		player.setSpeed(dto.getSpe_());
		player.setPower(dto.getPow_());
		player.setTechnique(dto.getTec_());
		player.setLowBall(dto.getLow_());
		player.setHighBall(dto.getHig_());
		return player;
	}

}
