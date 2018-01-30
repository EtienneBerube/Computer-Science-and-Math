package homework;

import java.util.Scanner;

public class Exercise_5_9 { // doesn't work well

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfNames;
		String name;
		int grade;
		int highscoreGrade1;
		int highscoreGrade2;
		String highscoreName1;
		String highscoreName2;

		System.out.print("Enter the number of students you want to grade: ");
		numberOfNames = input.nextInt();

		highscoreName1 = "";
		highscoreGrade1 = 0;
		highscoreName2 = "";
		highscoreGrade2 = 0;

		if (numberOfNames > 0) {

			for (int i = 0; i < numberOfNames; i++) {

				System.out.print("Enter the name of the student: ");
				name = input.next();

				System.out.print("Enter his grade: ");
				grade = input.nextInt();

				if (grade > highscoreGrade1) {
					highscoreGrade1 = grade;
					highscoreName1 = name;
				} else if (grade < highscoreGrade1 && grade > highscoreGrade2) {
					highscoreGrade2 = grade;
					highscoreName2 = name;
				}
			}
			System.out.println("The best students are " + highscoreName1
					+ " with " + highscoreGrade1 + "% and " + highscoreName2
					+ " wtih " + highscoreGrade2 + "%");
		} else {
			System.out.println("This ammount can't be processed");
			System.exit(0);
		}

	}

}
