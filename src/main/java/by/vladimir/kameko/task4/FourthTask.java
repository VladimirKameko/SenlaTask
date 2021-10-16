package by.vladimir.kameko.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Создайте программу, которая будет получать число и печатать его
 * (формы цифр можно придумать свои, главное, чтобы они читались на экране).
 * (*) Дополнительно: сделайте так, чтобы наибольшая цифра состояла не из ‘*’,
 * а из соответствующих маленьких (обычных) цифр.
 */
public class FourthTask {
	public static void main(String[] args) throws IOException {
		String num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Insert number. Enter STOP for exit");
		num = br.readLine();
		while (!(num.equalsIgnoreCase("STOP"))) {
			if (!Util.isNumeric(num)) {
				System.err.println("the input must only contain an integer ");
			} else {

				Util.init(num);
			}
			num = br.readLine();
		}

	}
}
