package Operations;

import domain.Student;
import domain.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AddStudent
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER STUDENT NAME:");
        String sName=sc.next();
        System.out.println("ENTER EMAIL:");
        String emailId=sc.next();
        System.out.println("ENTER 10th PER:");
        double teenthPer=sc.nextDouble();
        System.out.println("ENTER 12th PER:");
        double twelevePer=sc.nextDouble();
        System.out.println("ENTER DEGREE PER:");
        double degreePer= sc.nextDouble();
        System.out.println("ENTER STREAM:");
        String stream=sc.next();

        //DECLARE THE RESOURCES
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //CREATE THE OBJECT
        cfg=new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(StudentDetails.class);
        cfg=cfg.configure();
        factory=cfg.buildSessionFactory();
        ses=factory.openSession();




        //ADD DETAILS IN STUDENT DETAILS CLASS
        StudentDetails s2=new StudentDetails();
        s2.setTeenthPer(teenthPer);
        s2.setTwelevePer(twelevePer);
        s2.setDegreePer(degreePer);
        s2.setStream(stream);

        //ADD THE DETAILS IN STUDENT CLASS
        Student s1=new Student();
        s1.setsName(sName);
        s1.setEmailId(emailId);
        s1.setStudentRef(s2);

        tx=ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("RECORD INSERTED SUCESFULLY!!!");

    }
}
