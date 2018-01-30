package inheritence_test;

public class CourseTest {

	
	public static void main(String[] args) {
		Teacher teacher1 = new Teacher("Jean-Pistache Delarenta");
		Teacher teacher2 = new Teacher("Gustave MontGomery");
		
		Course course1 = new Course("The Pastafarians 105");
		Course course2 = new Course("Introduction to Unicorns");
		Course course3 = new Course("The hermeneutic of Tinder");

		
		Student student1 = new Student("A1", "111 Main blvd, Albany", "babagnouj@hotjack.com", "senior");
		Student student2 = new Student("A2", "111 Main blvd, Albany", "babagnouj@hotjack.com", "senior");
		Student student3 = new Student("A3", "111 Main blvd, Albany", "babagnouj@hotjack.com", "senior");
		Student student4 = new Student("A4", "111 Main blvd, Albany", "babagnouj@hotjack.com", "senior");
		Student student5 = new Student("A5", "111 Main blvd, Albany", "babagnouj@hotjack.com", "senior");
		Student student6 = new Student("A6", "111 Main blvd, Albany", "babagnouj@hotjack.com", "senior");
		Student student7 = new Student("A7", "111 Main blvd, Albany", "babagnouj@hotjack.com", "senior");
		Student student8 = new Student("A8", "111 Main blvd, Albany", "babagnouj@hotjack.com", "senior");
		Student student9 = new Student("A9", "111 Main blvd, Albany", "babagnouj@hotjack.com", "senior");
		Student student10 = new Student("A10", "111 Main blvd, Albany", "babagnouj@hotjack.com", "senior");
		
		//presets
		teacher1.addCourse(course1);
		teacher1.addCourse(course2);
		teacher2.addCourse(course3);
		
		teacher1.printList();
		teacher2.printList();
		
		//presets
		student1.addClass(course1);
		student1.addClass(course2);
		student2.addClass(course1);
		student3.addClass(course2);
		student4.addClass(course3);
		student5.addClass(course3);
		student6.addClass(course1);
		student7.addClass(course1);
		student8.addClass(course2);
		student9.addClass(course3);
		student10.addClass(course3);
		
		course1.printStudentList();
		course2.printStudentList();
		course3.printStudentList();
	
		student1.printClassList();
		
		student1.dropClass(course1);
		
		student1.printClassList();
		
	}

}
