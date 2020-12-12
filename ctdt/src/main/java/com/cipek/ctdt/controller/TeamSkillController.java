package com.cipek.ctdt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cipek.ctdt.model.request.TeamSkillRequest;
import com.cipek.ctdt.model.response.TeamSkillResponse;
import com.cipek.ctdt.service.TeamSkillService;

@RestController
@RequestMapping("/api/teamskill")
public class TeamSkillController {
	
	@Autowired
	private TeamSkillService teamSkillService;
	
	@PostMapping("/create")
	@Transactional(propagation = Propagation.REQUIRED)
	public TeamSkillResponse createType(@RequestBody TeamSkillRequest request) {
		return teamSkillService.create(request);
		
	}
	

}
