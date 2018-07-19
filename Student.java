package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses;
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	
	// Constructor: prompt user to enter name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student's first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student's last name: ");
		this.lastName = in.nextLine();
		
		this.gradeYear = CurrentYear();
		
		setStudentID();
		
		System.out.println(firstName + " " + lastName + " " + studentID);
	}
		
	private int CurrentYear() {
		System.out.print("1 - protoetis\n2 - theuteroetis\n3 - tritoetis\n4 - epiptuxio\nEnter student's class level: ");
		Scanner in = new Scanner(System.in);
		int yourYear = in.nextInt();
		if (yourYear ==1) {
			System.out.println("protoetis");
			return 1;
		}
		else if (yourYear == 2) {
			System.out.println("theuteroetis");
			return 2;
		}
		else if (yourYear == 3) {
			System.out.println("tritoetis");
			return 3;
		}
		else {
			System.out.println("epiptuxio");
			return 4;
		}
	}
	// Generate an ID
	private void setStudentID() {
		id++;
		this.studentID =   gradeYear+ "" + id;
	}
	// Enroll in courses
	public void enroll() {
		do {
			System.out.println("Enter course to enroll(Q to quit): ");
			Scanner in  = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q") && !course.equals("q")) {
				courses = courses + "\n " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}
			else {
				System.out.println("Goodbye!");
				break;
			}
		}
		while (1>0);
		
	}
	// View balance
	public void viewBalance() {
		System.out.println("Your tuition balance is " + tuitionBalance);
	}
	// Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: ");
		Scanner in  = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("You paid: " + payment + "$");
		viewBalance();
	}
	// Show status
	public String toString() {
		return "Name:" + firstName + " " + lastName + "Grade level: " + gradeYear + " Student ID: " + studentID + "\nCourses Enrolled:" + courses + "\nBalance: " + tuitionBalance +"$";
	}
	
}
