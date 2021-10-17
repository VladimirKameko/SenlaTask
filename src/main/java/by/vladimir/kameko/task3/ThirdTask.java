package by.vladimir.kameko.task3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Создайте программу, которая будет:
 * подсчитывать количество гласных в словах
 * выводить слова отсортированным списком по количеству гласных (сначала те, у которых больше гласных)
 * делать первую гласную букву в слове заглавной
 * Предложение вводится пользователем вручную русскими буквами. Разделитель пробел (“ ”).
 */


public class ThirdTask {

	public static final String REGEX_VOWELS = "[аеёиоуэюя]";
	public static final String REGEX_NOT_VOWELS = "[^аеёиоуэюя]";
	public static final String REGEX_NOT_LETTERS = "[^а-яёА-ЯЁ ]";

	public static void main(String[] args) {
		System.out.println("Enter text");
		Scanner sc = new Scanner(System.in);
		String inputData = sc.nextLine();

		String[] words = inputData.split(" ");

		Map<String, Integer> mapWithVowelsNumber = Stream.of(words)
				.distinct()
				.map(q -> q = q.replaceAll(REGEX_NOT_LETTERS, ""))
				.collect(Collectors.toMap(p -> p, i -> i.replaceAll(REGEX_NOT_VOWELS, "").length()));

		List<String> wordsListSortedByVowelsNumber = new ArrayList<>();
		mapWithVowelsNumber
				.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.forEach(e -> wordsListSortedByVowelsNumber.add(e.getKey()));

		List<String> finalResult = new ArrayList<>();
		new ThirdTask().uppersCaseFirstVowel(finalResult, wordsListSortedByVowelsNumber);

		System.out.println(finalResult);
	}

	private void uppersCaseFirstVowel(List<String> finalResult, List<String> wordsListSortedByVowelsNumber) {
		int pos;
		for (String word : wordsListSortedByVowelsNumber) {
			pos = 0;
			pos = getFirstVowelPosition(word, pos);

			if (pos >= 0) {
				word = word.replaceFirst(REGEX_VOWELS, Character.toString(word.charAt(pos)).toUpperCase());
				finalResult.add(word);
			}
		}
	}

	private int getFirstVowelPosition(String word, int pos) {
		Pattern pattern = Pattern.compile(REGEX_VOWELS);
		Matcher matcher = pattern.matcher(word);
		if (matcher.find()) {
			pos = matcher.start();
		}
		return pos;
	}


}
