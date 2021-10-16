package by.vladimir.kameko.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Util {
	public static Number[] num = new Number[10];

	public static String[] reader(int number) {
		String path = "src/main/resources/" + number + ".txt";
		String line;
		String[] nStr = new String[7];
		int i = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				line = line.replaceAll("q", " ");
				nStr[i] = line;
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return nStr;
	}


	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}


	private static boolean isHighestNumFind(int n, int[] numbers) {
		if (Arrays.stream(numbers).max().getAsInt() == n) {
			return true;
		}
		return false;
	}


	public static void init(String s) {
		int[] numbers = Arrays.stream(s.split("")).map(Integer::valueOf).mapToInt(a -> a).toArray();
		for (int i = 0; i < numbers.length; i++) {
			if (num[numbers[i]] == null) {
				num[numbers[i]] = new Number(reader(numbers[i]), isHighestNumFind(numbers[i], numbers));

			} else {
				num[numbers[i]].setHighest(isHighestNumFind(numbers[i], numbers));
			}
		}
		draw(numbers);
	}

	private static void draw(int[] numbers) {
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < numbers.length; i++) {
				if (num[numbers[i]].isHighest()) {

					System.out.print(num[numbers[i]].getFormatNumber()[j].replaceAll("\\*", "" + numbers[i]) + "   ");
				} else {

					System.out.print(num[numbers[i]].getFormatNumber()[j] + "   ");
				}
			}
			System.out.println();
		}
	}
}