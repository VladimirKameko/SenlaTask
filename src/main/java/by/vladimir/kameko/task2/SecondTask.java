package by.vladimir.kameko.task2;

import java.util.Scanner;

/**
 * Создайте программу, которая будет вычислять и выводить на экран
 * простые множители,из которых состоит целое число, введенное пользователем.
 * Если введенное число не целое, то нужно сообщать пользователю об ошибке.
 */


public class SecondTask {

	public static void main(String[] args) {
		SecondTask st = new SecondTask();
		System.out.println("Enter an integer");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		while (!st.checkNum(input)) {
			input = sc.next();
		}

	}

	public boolean checkNum(String input) {

		try {
			long q = Long.parseLong(input);
			findTheDivisors(q);
		} catch (NumberFormatException ex) {
			System.err.println("Enter an integer");
			return false;
		}
		return true;
	}

	public void findTheDivisors(long num) {

		for (long i = 2; i <= num; i++) {

			if (num % i == 0) {
				System.out.println(i + " ");
				num = num / i;
				findTheDivisors(num);
				break;
			}
		}
	}
}
