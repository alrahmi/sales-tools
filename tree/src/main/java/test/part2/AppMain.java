package test.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppMain {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 2, 23, 4, 5, 2, 89, 2));
		DeletFromList.removeRepeatedNInARow(list, 4);
		System.out.println(list);
	}
}
