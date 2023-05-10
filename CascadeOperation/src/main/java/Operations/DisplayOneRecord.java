package Operations;

import com.sun.corba.se.impl.legacy.connection.USLPort;
import domain.Student;
import domain.StudentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DisplayOneRecord
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE ID");
        int id=sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(StudentDetails.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        Student s1=ses.get(Student.class,id);

        System.out.println("STUDENT ID:  "+s1.getStudentId());
        System.out.println("STUDENT NAME:"+s1.getsName());
        System.out.println("EMAIL ID:"+s1.getEmailId());
        System.out.println("10TH PERCENTAGE:"+s1.getStudentRef().getTeenthPer());
        System.out.println("12TH PERCENTAGE:"+s1.getStudentRef().getTwelevePer());
        System.out.println("DEGREE PERCENTAGE:"+s1.getStudentRef().getDegreePer());
        System.out.println("STREAM: "+s1.getStudentRef().getStream());

    }
}
