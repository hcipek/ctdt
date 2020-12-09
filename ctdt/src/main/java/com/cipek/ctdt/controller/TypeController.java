package com.cipek.ctdt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cipek.ctdt.model.request.TypeRequest;
import com.cipek.ctdt.model.response.TypeResponse;
import com.cipek.ctdt.service.TypeService;

@RestController
@RequestMapping("/api/type")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@PostMapping("/create")
	@Transactional(propagation = Propagation.REQUIRED)
	public TypeResponse createType(@RequestBody TypeRequest request) {
		return typeService.create(request);
		
	}

}
