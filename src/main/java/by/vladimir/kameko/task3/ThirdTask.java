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
	public static void main(String[] args) {
		System.out.println("Enter text");
		Scanner sc = new Scanner(System.in);
		Pattern pattern = Pattern.compile("[аеёиоуэюя]");


		String line = sc.nextLine();
		List<String> result = new ArrayList<>();
		List<String> finalResult = new ArrayList<>();


		String[] str = line.split(" ");

		Stream.of(str)

				.distinct()
				.map(q -> q = q.replaceAll("[^а-яёА-ЯЁ ]", ""))
				.collect(Collectors.toMap(p -> p, i -> i.replaceAll("[аеёиоуэюя]", "").length()))
				.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.forEach(e -> result.add(e.getKey()));


		for (String s : result) {
			int i = 0;
			Matcher m = pattern.matcher(s);
			if (m.find()) {
				i = m.start();
				System.out.println(i);
			}

			if (i >= 0) {
				s = s.replaceFirst("[аеёиоуэюя]", Character.toString(s.charAt(i)).toUpperCase());
				finalResult.add(s);
			}

		}
		System.out.println(finalResult);
	}


}
