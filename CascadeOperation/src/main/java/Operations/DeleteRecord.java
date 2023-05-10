package Operations;

import domain.Student;
import domain.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteRecord
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE ID:");
        int id=sc.nextInt();
        //DECLARE THE RESOURCES
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //create the object
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(StudentDetails.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();


        Student s1=ses.get(Student.class,id);
        tx= ses.beginTransaction();
        ses.delete(s1);
        tx.commit();

        System.out.println("STUDENT RECORD DELETED SUCESFULLY!!");

    }
}
