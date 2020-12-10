package com.cipek.ctdt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.cipek.ctdt.model.response.RestCountriesResponse;
import com.cipek.ctdt.model.type.CategoryType;
import com.cipek.ctdt.model.type.NationType;
import com.cipek.ctdt.model.type.RegionType;
import com.cipek.ctdt.repository.TypeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CountryService {

	private static String A = "a";
	private static String N = "n";
	private static String AN = "an";
	private static String AMERICAN = "Americas";
	private static String LATIN_AMERICAN = "Latin American";
	private static String JAPANESE = "Japanese";
	private static String NON_JAPANESE = "Non-Japanese";
	
	@Autowired
	private TypeRepository typeRepo;
	
	private String restCountriesRequestBaseURL = "https://restcountries.eu/rest/v2/";
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Transactional(propagation = Propagation.REQUIRED)
	public NationType getCountryDetailsByCountryName(String name) {
		
		log.debug("");
		String tempName = nameSwitcher(name);
		String url = restCountriesRequestBaseURL.concat("name/").concat(tempName);
		RestCountriesResponse[] restCountriesResponseArray = restTemplate.getForObject(url, RestCountriesResponse[].class);
		
		if(restCountriesResponseArray.length != 0) {
			RestCountriesResponse resp = restCountriesResponseArray[0];
			NationType type = new NationType();
			
			String regionName = resp.getRegion().endsWith(A) ? resp.getRegion().concat(N) : resp.getRegion().concat(AN);
			regionName = regionName.contains(AMERICAN) ? LATIN_AMERICAN : regionName;
			RegionType regionType = (RegionType)typeRepo.findByName(regionName);
			
			String categoryName = resp.getDemonym().equals(JAPANESE) ? resp.getDemonym() : NON_JAPANESE;
			CategoryType categoryType = (CategoryType)typeRepo.findByName(categoryName);
			
			type.setCategoryType(categoryType);
			type.setRegionType(regionType);
			type.setName(name);
			return typeRepo.save(type);
		}
		
		return null;
	}
	
	private String nameSwitcher(String name) {
		if(name.equals("South Korea"))
			return "Korea (Republic of)";
		else if(name.equals("England"))
			return "Great Britain";
		return name;
	}

}
