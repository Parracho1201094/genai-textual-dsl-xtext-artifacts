package org.enorm.domain.utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListUtils {

	public static <T> List<T> reorderListBasedOnAnother(List<T> list1, List<T> list2) {
		Map<T, Integer> orderMap = new HashMap<>();
		for (int i = 0; i < list1.size(); i++) {
			orderMap.put(list1.get(i), i);
		}

		// Sort list2 based on the order defined in list1
		list2.sort(Comparator.comparingInt(orderMap::get));

		return list2;
	}

}

