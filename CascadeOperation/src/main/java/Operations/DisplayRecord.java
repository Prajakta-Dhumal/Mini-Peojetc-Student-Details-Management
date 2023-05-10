package Operations;

import domain.Student;
import domain.StudentDetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Scanner;

public class DisplayRecord
{
    public static void main(String[] args) {

        //DECLARE THE RESOURCES
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        //CREATE THE OBJECT
        cfg=new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(StudentDetails.class);
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();
        Criteria crt=ses.createCriteria(Student.class);
        List<Student> studentList=crt.list();

        for (Student s1:studentList){
            System.out.println("==========================================");
            System.out.println("STUDENT ID:   "+s1.getStudentId());
            System.out.println("STUDENT NAME: "+s1.getsName());
            System.out.println("STUDENT EMAIL:"+s1.getEmailId());
            System.out.println("10TH   PER:   "+s1.getStudentRef().getTeenthPer());
            System.out.println("12th PER:     "+s1.getStudentRef().getTwelevePer());
            System.out.println("DGREE PER:    "+s1.getStudentRef().getDegreePer());
            System.out.println("STREAM:       "+s1.getStudentRef().getStream());
            System.out.println("==========================================");
        }

    }
}
