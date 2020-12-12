package com.cipek.ctdt.util;

import java.util.List;

public class StringUtils extends org.apache.commons.lang3.StringUtils{
	
	public static Boolean containsAny(String value, List<String> valueList) {
		return valueList.stream().anyMatch(e -> value.contains(e));
	}

}
