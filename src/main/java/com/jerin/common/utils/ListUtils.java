package com.jerin.common.utils;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

	public static String getCommaSeparatedString(List<? extends Object> list) {
		return list.stream().map(Object::toString).collect(Collectors.joining(","));
	}

}
