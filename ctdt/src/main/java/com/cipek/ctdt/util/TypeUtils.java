package com.cipek.ctdt.util;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cipek.ctdt.exception.IllegalTypeCodeException;
import com.cipek.ctdt.model.type.CategoryType;
import com.cipek.ctdt.model.type.ColorType;
import com.cipek.ctdt.model.type.CompetitionSuperType;
import com.cipek.ctdt.model.type.CompetitionType;
import com.cipek.ctdt.model.type.NationType;
import com.cipek.ctdt.model.type.RegionType;
import com.cipek.ctdt.model.type.StructureSuperType;
import com.cipek.ctdt.model.type.TeamSkillType;

public class TypeUtils {

	public static String REGION_TYPE = "RegionType";
	public static String CATEGORY_TYPE = "CategoryType";
	public static String COMPETITION_SUPER_TYPE = "CompetitionSuperType";
	public static String TEAM_SKILL_TYPE = "TeamSkillType";
	public static String STRUCTURE_SUPER_TYPE = "StructureSuperType";
	public static String COMPETITION_TYPE = "CompetitionType";
	public static String NATION_TYPE = "NationType";
	public static String COLOR_TYPE = "ColorType";
	
	private static Map<Integer, Class<?>> typeCodeMap = Stream.of(
			new AbstractMap.SimpleEntry<>(1001, RegionType.class),
			new AbstractMap.SimpleEntry<>(1002, CategoryType.class),
			new AbstractMap.SimpleEntry<>(1003, CompetitionSuperType.class),
			new AbstractMap.SimpleEntry<>(1004, TeamSkillType.class),
			new AbstractMap.SimpleEntry<>(1005, StructureSuperType.class),
			new AbstractMap.SimpleEntry<>(1006, CompetitionType.class),
			new AbstractMap.SimpleEntry<>(1007, NationType.class),
			new AbstractMap.SimpleEntry<>(1008, ColorType.class)
			).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	
	public static Class<?> getTypeByCode(Integer code) {
		 Entry<Integer, Class<?>> entry = typeCodeMap.entrySet().stream().filter(e->e.getKey().equals(code)).findFirst().orElse(null);
		 if(entry == null) {
			 throw new IllegalTypeCodeException("This cod_ is invalid");
		 }
		 return entry.getValue();
	}
	
	public static Entry<Integer, Class<?>> getEntryByCode(Integer code) {
		 Entry<Integer, Class<?>> entry = typeCodeMap.entrySet().stream().filter(e->e.getKey().equals(code)).findFirst().orElse(null);
		 if(entry == null) {
			 throw new IllegalTypeCodeException("This cod_ is invalid");
		 }
		 return entry;
	}

}
