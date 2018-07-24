package com.rit.date;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgeCalculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Which year were you born:");
		int year = scan.nextInt();
		System.out.println("Which month were you born:");
		int month = scan.nextInt();
		System.out.println("Whats the day of the month when you were born:");
		int day = scan.nextInt();

		LocalDate birthdate = null;
		try {
			birthdate = LocalDate.of(year, month, day);
		} catch (DateTimeException exp) {
			System.out.println("You entered incorrect Birth Date");
			return;

		}

		System.out.format("Birth Date %s", birthdate.format(DateTimeFormatter.ISO_DATE));
		LocalDate now = LocalDate.now();
		Period p = Period.between(birthdate, now);
		System.out.println();
		if (!validateBirthdate(birthdate, now)) {
			return;
		}

		System.out.format("You are %d years old", p.getYears());
		scan.close();
	}

	private static Boolean validateBirthdate(LocalDate birthdate, LocalDate now) {
		if (now.compareTo(birthdate) < 0) {
			System.out.println("You entered incorrect Birth Date");
			return false;
		}

		return true;
	}

}
