package com.JSpider.Student_Manage_System;
import java.util.Scanner;
public class StudentApp 
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDAO();
		while(true)
		{
			System.out.println("1. Insert \n 2. Delete \n 3. Modify \n 4. Display \n 5. Exit");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				sdao.insertStudent();
				break;
			case 2:
				sdao.deleteStudent();
				break;
			case 3:
				sdao.modifyStudent();
				break;
			case 4:
				sdao.displayStudent();
				break;
			case 5:
				System.out.println("Thank You...");
				return;
			default:
				System.out.println("You have entered wrong choice...");
				break;
			}
		}
	}
}
