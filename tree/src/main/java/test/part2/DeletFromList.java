package test.part2;

import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

public class DeletFromList {
	public static <T> List<T> removeRepeatedNInARow(List<T> list, int n) {
		if (n < 2) {
			throw new IllegalArgumentException("N must be greater or equal 2");
		}
		T repeatednumbers = null;
		int Index = -1;
		int Countner = 1;
		int i = 0;

		while (i < list.size()) {
			
			if (Index < 0 || !Objects.equals(repeatednumbers, list.get(i))) {
				Index = i;
				repeatednumbers = list.get(i);
				Countner = 1;
				i++;
			} else {
				Countner++;
				if (Countner >= n) {
					for (int j = Index; j <= i; j++) {
						list.remove(Index);
					}
					i = Index;
				} else {
					i++;
				}
			}
		}
		return list;
	}
	
	public static <T> List<T> removeNRepeated(List<T> list, int n) {
		if (n < 2) {
			throw new IllegalArgumentException("N must be greater or equal 2");
		}
		
		final List<T> repeatedNumbers = list.parallelStream().distinct()
				.filter(number -> list.parallelStream().filter(element -> element.equals(number)).count() >= n)
				.collect(Collectors.toList());
		list.removeAll(repeatedNumbers);
		return list;
	}
}
