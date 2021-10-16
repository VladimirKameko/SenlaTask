package by.vladimir.kameko.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке.
 * Если цифр нет, то возвращаемая сумма должна быть равна 0
 */
public class FirstTask {

	private static final String REGEXP_ANY_NON_DIGIT = "[^0-9]";

	public static void main(String[] args) {
		FirstTask firstTask = new FirstTask();
		String inputData = firstTask.readDataFromConsole();
		int sum = firstTask.calculateSum(inputData);
		System.out.println(sum);
	}


	/**
	 * This method calculate sum of numbers from input data.
	 *
	 * @param inputData - a string of numbers and symbols
	 * @return sum of numbers from input data.
	 */
	public int calculateSum(String inputData) {
		int sum = 0;

		if (inputData == null || inputData.isBlank()) {
			return 0;
		}

		String stringOfNumbers = inputData.replaceAll(REGEXP_ANY_NON_DIGIT, "");

		if (stringOfNumbers.isEmpty()) {
			return 0;
		}

		for (String st : stringOfNumbers.split("")) {
			sum = sum + Integer.parseInt(st);
		}

		return sum;
	}


	private String readDataFromConsole() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
