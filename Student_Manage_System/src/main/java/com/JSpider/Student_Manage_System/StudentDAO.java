package com.JSpider.Student_Manage_System;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class StudentDAO 
{
	private static Scanner sc;
	private static Session ss;
	static {
		sc=new Scanner(System.in);
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		ss=sf.openSession();
	}
	public void insertStudent() 
	{
		System.out.println("Enter Student_Id ");
		System.out.println("Enter Student_Name ");
		System.out.println("Enter Student_Percentage ");
		Student_MS s=new Student_MS();
		s.setStudent_Id(sc.nextInt());
		s.setStudent_Name(sc.next());
		s.setStudent_Perc(sc.nextDouble());
		try {
			Transaction tr=ss.beginTransaction();
			ss.save(s);
			tr.commit();
		} 
		catch (Exception e) {
			System.out.println("This Student_id is already exist in Database");
			return;
		}
		System.out.println("Successfully Inserted...");
	}
	public void deleteStudent()
	{
		System.out.println("Enter the Id to delete ");
		int id=sc.nextInt();
		try {
			Student_MS s=(Student_MS)ss.load(Student_MS.class, id);
			Transaction tr=ss.beginTransaction();
			ss.delete(s);
			tr.commit();
		} 
		catch (Exception e) {
			System.out.println("This Student_Id is not exist in Database");
			return;
		}
		System.out.println("Successfully deleted...");
	}
	public void modifyStudent()
	{
		System.out.println("Enter the id to modify ");
		int id=sc.nextInt();
		try {
				Student_MS s=(Student_MS)ss.load(Student_MS.class, id);
				Transaction tr=ss.beginTransaction();
				System.out.println("1.Modify Name \n 2. Modify Percentage");
				int key=sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("Enter new Student_Name ");
					s.setStudent_Name(sc.next());
					break;
				case 2:
					System.out.println("Enter new Student_Percentage ");
					s.setStudent_Perc(sc.nextDouble());
					break;
				default:
					System.out.println("Input is wrong");
					return;
				}
				tr.commit();
		} 
		catch (Exception e) {
			System.out.println("This Student_Id is not exist in Database");
			return;
		}
		System.out.println("Successfully modified");
	}
	public void displayStudent()
	{
		System.out.println("Enter the Id to Read ");
		int id=sc.nextInt();
		try {
			Student_MS s=(Student_MS)ss.load(Student_MS.class, id);
			System.out.println("Student Info ");
			System.out.println("Student_Id "+s.getStudent_Id());
			System.out.println("Student_Name "+s.getStudent_Name());
			System.out.println("Student_Percentage "+s.getStudent_Perc());
		} 
		catch (Exception e) {
			System.out.println("This Student_Id is not exist in Database");
			return;
		}
		System.out.println("Successfully Read the Student");
	}
}
