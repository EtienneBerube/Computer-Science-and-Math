package homework;

import java.util.*;

public class Exercise_5_8 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int numberOfNames;
		String name;
		int grade;
		int highscoreGrade;
		String highscoreName;

		System.out.print("Enter the number of students you want to grade: ");
		numberOfNames = input.nextInt();

		highscoreName = "";
		highscoreGrade = 0;

		if (numberOfNames > 0) {

			for (int i = 0; i < numberOfNames; i++) {

				System.out.print("Enter the name of the student: ");
				name = input.next();

				System.out.print("Enter his grade: ");
				grade = input.nextInt();

				if (grade < 0 || grade > 100) {
					System.out.println("Invalid grade");
				} else if (grade > highscoreGrade) {
					highscoreGrade = grade;
					highscoreName = name;
				}
			}
			System.out.println("" + highscoreName + " is the best with "
					+ highscoreGrade + "%");
		} else {
			System.out.println("This ammount can't be processed");
			System.exit(0);
		}

	}

}
