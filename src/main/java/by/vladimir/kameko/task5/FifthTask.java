package by.vladimir.kameko.task5;

import java.util.ArrayList;


/**
 * Есть набор предметов, задаваемый заранее, предметы могут повторяться.
 * Предмет имеет 2 параметра (обязательных, остальные добавлять на усмотрение):
 * объем (целое значение) и ценность (целое значение).
 * Предметы неделимы. Также задаётся сейф с обязательным параметром его объёма (целое значение).
 * <p>
 * Нужно написать программу, которая наполняет сейф набором предметов таким образом,
 * чтобы ценность этого набора была максимальной.
 */


public class FifthTask {

	private static Safe safe = new Safe(new ArrayList<>(), 4);

	private static Item[] items = {
			new Item("кольцо1", 2500, 1),
			new Item("подвеска", 2000, 3),
			new Item("ожерелье", 4000, 4),
	};

	public static void main(String[] args) {
		SafeUtil safeUtil = new SafeUtil(safe, items);
		safeUtil.fillingSafeCorrect();
		System.out.println(safeUtil.getSafe().getDescription());
	}
}
